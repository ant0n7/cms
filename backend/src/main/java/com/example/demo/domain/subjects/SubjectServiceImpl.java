package com.example.demo.domain.subjects;

import com.example.demo.domain.appuser.UserRepository;
import com.example.demo.domain.appuser.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @Override
    public Subject saveSubject(Subject subject) throws InstanceAlreadyExistsException {
        if (subjectRepository.findBySubjectname(subject.getSubjectname()) != null) {
            throw new InstanceAlreadyExistsException("Subject already exists");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(String subjectName) {
        return subjectRepository.findBySubjectname(subjectName);
    }

    @Override
    public Optional<Subject> findById(UUID id) throws InstanceNotFoundException {
        if (subjectRepository.existsById(id)) {
            return subjectRepository.findById(id);
        } else {
            throw new InstanceNotFoundException("Subject not found");
        }
    }

    @Override
    public List<Subject> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (userService.getRoleByUsername(auth.getName()).equals("STUDENT")){
            return findByUsername(auth.getName());
        }
        return subjectRepository.findAll();
    }

    @Override
    public void deleteSubject(UUID id) throws InstanceNotFoundException {
        if (!subjectRepository.existsById(id)) throw new InstanceNotFoundException();
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject updateSubject(UUID id, Subject subject) throws InstanceNotFoundException {
        if (!subjectRepository.existsById(id)) throw new InstanceNotFoundException();
        subject.setId(id);
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public List<Subject> findByUsername(String username) {

        List<String> classes = subjectRepository.getClassesByUser(userRepository.findByUsername(username).getId());
        List<String> subjects = new ArrayList<>();
        for (String c : classes) {
            subjects.addAll(subjectRepository.getSubjectsByClass(UUID.fromString(c)));
        }

        return convertIdToSubject(subjects);

    }

    @Override
    public List<Subject> findByUserID(UUID id) throws AccessDeniedException {
        if (hasAccess(id)){
            List<String> classes = subjectRepository.getClassesByUser(id);
            List<String> subjects = new ArrayList<>();

            for (String c : classes) {
                subjects.addAll(subjectRepository.getSubjectsByClass(UUID.fromString(c)));
            }
            List<String> subjectsWithoutDuplicates = new ArrayList<>(new HashSet<>(subjects));

            return convertIdToSubject(subjectsWithoutDuplicates);
        }
        throw new AccessDeniedException("No access");
    }


    private List<Subject> convertIdToSubject(List<String> subjects) {
        List<Subject> obj = new ArrayList<>();
        for (String s: subjects) {
            obj.add(subjectRepository.findById(UUID.fromString(s)).orElse(null));
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


