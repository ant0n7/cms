package com.example.demo.domain.appclass;

import com.example.demo.domain.appclass.dto.CreateClassDTO;
import com.example.demo.domain.appclass.dto.RestrictedClassInformationDTO;
import com.example.demo.domain.appuser.User;
import com.example.demo.domain.appuser.UserRepository;
import com.example.demo.domain.appuser.UserServiceImpl;
import com.example.demo.domain.subjects.Subject;
import com.example.demo.domain.subjects.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final ClassMapper classMapper;
    private final UserServiceImpl userService;

    @Override
    public Class saveClass(CreateClassDTO appclass) throws InstanceAlreadyExistsException, InstanceNotFoundException {
        Class newClass = new Class();
        newClass.setClassname(appclass.getClassname());
        newClass.setMembers(convertUsernameToUser(appclass.getMembers()));
        newClass.setSubjects(convertSubjectnameToSubject(appclass.getSubjects()));
        if (classRepository.findByClassname(newClass.getClassname()) != null){
            throw new InstanceAlreadyExistsException("Class already exists");
        }
        return classRepository.save(newClass);
    }

    @Override
    public Optional<Class> findById(UUID id) throws InstanceNotFoundException {
        if (classRepository.existsById(id)){
            return classRepository.findById(id);
        }
        else {
            throw new InstanceNotFoundException("Subject not found");
        }
    }

    @Override
    public List<Class> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (userService.getRoleByUsername(auth.getName()).equals("STUDENT")){
            return  (findClassesByUsername(auth.getName()));
        }
        return classRepository.findAll();
    }

    @Override
    public void deleteClass(UUID id) throws InstanceNotFoundException {
        if (!classRepository.existsById(id)) throw new InstanceNotFoundException();
        classRepository.deleteById(id);
    }

    @Override
    public Class updateClass(UUID id, Class subject) throws InstanceNotFoundException {
        if (!classRepository.existsById(id)) throw new InstanceNotFoundException();
        subject.setId(id);
        return classRepository.saveAndFlush(subject);
    }

    @Override
    public void addUserToClass(UUID classID, UUID userID) throws InstanceNotFoundException {
        Class appclass;
        User user;
        if (classRepository.existsById(classID) && userRepository.existsById(userID)){
            appclass = classRepository.getById(classID);
            user = userRepository.getById(userID);
            appclass.getMembers().add(user);
        } else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public void addSubjectToClass(UUID classID, UUID subjectID) throws InstanceNotFoundException {
        Class appclass;
        Subject subject;
        if (classRepository.existsById(classID) && subjectRepository.existsById(subjectID)){
            appclass = classRepository.getById(classID);
            subject = subjectRepository.getById(subjectID);
            appclass.getSubjects().add(subject);
        } else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public List<RestrictedClassInformationDTO> findRestrictedClassesByUsername(String username){
        return  convertIdToRestrictedClass(classRepository.findClassesByUser(userRepository.findByUsername(username).getId()));
    }

    @Override
    public List<Class> findClassesByUsername(String username){
        return  convertIdToClass(classRepository.findClassesByUser(userRepository.findByUsername(username).getId()));
    }



    @Override
    public List<Class> findClassesByUserID(UUID id) throws InstanceNotFoundException, AccessDeniedException {
        if (hasAccess(id)){
            try{
                return  convertIdToClass(classRepository.findClassesByUser(id));
            } catch (Exception e){
                throw new InstanceNotFoundException("User  does not exist");
            }
        }
        throw new AccessDeniedException("You don't have access");

    }

    @Override
    public List<Class> findClassesBySubject(String subjectname) throws InstanceNotFoundException {
        try{
            return  convertIdToClass(classRepository.findClassesByUser(subjectRepository.findBySubjectname(subjectname).getId()));
        } catch (Exception e){
            throw new InstanceNotFoundException("Subject " + subjectname + " does not exist");
        }
    }

    @Override
    public List<Class> findClassesBySubjectID(UUID id) throws InstanceNotFoundException {
        try{
            return  convertIdToClass(classRepository.findClassesBySubject(id));
        } catch (Exception e){
            throw new InstanceNotFoundException("Subject does not exist");
        }
    }


    private List<RestrictedClassInformationDTO> convertIdToRestrictedClass(List<String> uuid){
        List<RestrictedClassInformationDTO> obj = new ArrayList<>();
        for (String u: uuid) {
            obj.add(classMapper.classToRestrictedClassInformationDTO(classRepository.findById(UUID.fromString(u)).orElse(null)));
        }
        return obj;
    }
    private List<Class> convertIdToClass(List<String> uuid){
        List<Class> obj = new ArrayList<>();
        for (String u: uuid) {
            obj.add(classRepository.findById(UUID.fromString(u)).orElse(null));
        }
        return obj;
    }

    private List<User> convertUsernameToUser(List<String> username) throws InstanceNotFoundException {
        List<User> obj = new ArrayList<>();
                for (String u : username) {
                try {
                    userRepository.findByUsername(u).getUsername();
                    obj.add(userRepository.findByUsername(u));
                }catch (RuntimeException e){
                    throw new InstanceNotFoundException(u + " is no valid user");
                }

            }
        return obj;
    }

    private List<Subject> convertSubjectnameToSubject(List<String> subjectname){
        List<Subject> obj = new ArrayList<>();
        for (String s: subjectname) {
            obj.add(subjectRepository.findBySubjectname(s));
        }
        return obj;
    }

    private boolean hasAccess(UUID id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            // if user is requesting his own profile return true
            return id.equals(userRepository.findByUsername(auth.getName()).getId()) ||
                    auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TEACHER"));
        } catch (Exception e) {
            // do not grant access if user couldn't be found/verified to prevent giving a potential attacker
            // information
            return false;
        }
    }



}
