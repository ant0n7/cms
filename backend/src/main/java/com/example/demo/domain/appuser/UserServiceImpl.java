package com.example.demo.domain.appuser;

import com.example.demo.domain.appclass.ClassRepository;
import com.example.demo.domain.appuser.dto.CreateUserDTO;
import com.example.demo.domain.appuser.dto.LoginDTO;
import com.example.demo.domain.exceptions.InvalidEmailException;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.subjects.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.Level;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.transaction.Transactional;

import java.util.*;

@Service @RequiredArgsConstructor @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SubjectRepository subjectRepository;
    private final ClassRepository classRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final String[] errorMessages = new String[]
            {"User not found", "Email is not valid", "Username already exists", "Email already exists"};

    @Override
//    This method is used for security authentication, use caution when changing this
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        else {
//          Construct a valid set of Authorities (needs to implement Granted Authorities)
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
                role.getAuthorities().forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getName())));
            });
//            return a spring internal user object that contains authorities and roles
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        List<GrantedAuthority> authorities
                = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
            role.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                    .forEach(authorities::add);
        }
        return authorities;
    }

    @Override
    public User createUser(CreateUserDTO userDto) throws InstanceAlreadyExistsException, InvalidEmailException {
        if (!EmailValidator.getInstance().isValid(userDto.getEmail())) {
            throw new InvalidEmailException(errorMessages[1]);
        }
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new InstanceAlreadyExistsException(errorMessages[2]);
        }
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new InstanceAlreadyExistsException(errorMessages[3]);
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        //Set default role of every new user to USER
        User user = userMapper.createUserDTOToUser(userDto);
        user.setRoles(List.of(roleRepository.findByRolename("STUDENT")));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRolename(rolename);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public Optional<User> findById(UUID id) throws InstanceNotFoundException{
        if(hasAccess(id)){

        }
        if (userRepository.existsById(id)){
            return userRepository.findById(id);
        }
        else {
            throw new InstanceNotFoundException("User not found");
        }
    }


    @Override
    public List<User> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (getRoleByUsername(auth.getName()).equals("STUDENT")){
            return List.of(userRepository.findByUsername(auth.getName()));
        }
        return userRepository.findAll();
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

    @Override
    public User updateUser(UUID id, User user) throws InstanceNotFoundException, InvalidEmailException, InstanceAlreadyExistsException {
        if (!userRepository.existsById(id)) throw new InstanceNotFoundException("User does not exist.");

        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new InvalidEmailException(errorMessages[1]);
        }
        //When updating a user he needs the possibility to keep his username, but in case he changes it we need to
        // check if it's already in use
        if (userRepository.findByUsername(user.getUsername()) != null &&  /* true = username may be updated*/
                /*true = username does not belong to updated profile */
                !user.getUsername().equals(userRepository.findById(user.getId()).get().getUsername())) {
            throw new InstanceAlreadyExistsException(errorMessages[2]);
        }
        if (userRepository.findByEmail(user.getEmail()) != null &&  /* true = email maybe updated*/
                /*true = email does not belong to updated profile */
                !user.getEmail().equals(userRepository.findById(user.getId()).get().getEmail())) {
            throw new InstanceAlreadyExistsException(errorMessages[3]);
        }
        // If password is updated -> encrypt, else -> do nothing
        if (!(passwordEncoder.matches(/* Maybe updated password */ user.getPassword(),
                /* Old password */ userRepository.findById(user.getId()).get().getPassword()))) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(UUID id) throws InstanceNotFoundException {
        if (!userRepository.existsById(id)) throw new InstanceNotFoundException("User does not exist.");
        userRepository.deleteFromClass(id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUsersBySubject(UUID id) throws InstanceNotFoundException {
       if (subjectRepository.existsById(id)){
            List<String> classes = userRepository.getClassesBySubject(id);
           List<String> users = new ArrayList<>();
           for (String c: classes) {
               users.addAll(userRepository.getUsersByClass(UUID.fromString(c)));
           }

            List<UUID> students = new ArrayList<>();
            for (String u: users){
                if (userRepository.findAllStudents().contains(u)){
                    students.add(UUID.fromString(u));
                }
            }
            return convertIdToUser(students);
        }else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public List<User> findUsersByClass(UUID id) throws InstanceNotFoundException {
        if (classRepository.existsById(id)){
            List<String> users = userRepository.getUsersByClass(id);
            List<UUID> students = new ArrayList<>();
            for (String u: users){
                if (userRepository.findAllStudents().contains(u)){
                    students.add(UUID.fromString(u));
                }
            }
            return convertIdToUser(students);
        }else {
            throw new InstanceNotFoundException();
        }
    }

    @Override
    public boolean verifyLogin(LoginDTO loginDTO) {
        try {
            User user = userRepository.findByUsername(loginDTO.getUsername());
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
                return true;
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public String getRoleByUsername(String username) {
        return userRepository.getRole(username);
    }

    private List<User> convertIdToUser(List<UUID> uuid){
        List<User> obj = new ArrayList<>();
        for (UUID u: uuid) {
            obj.add(userRepository.findById(u).orElse(null));
        }
        return obj;
    }

}
