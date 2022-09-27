package com.example.demo.domain.appuser;


import com.example.demo.domain.appuser.dto.CreateUserDTO;
import com.example.demo.domain.appuser.dto.LoginDTO;
import com.example.demo.domain.exceptions.InvalidEmailException;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController @RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('TEACHER') || hasRole('STUDENT') || hasRole('ADMIN')")
    @Operation(summary = "List of all users.", description = "Get a list of all users with all their information.")
    @GetMapping("/")
    public ResponseEntity<Collection<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Save a single user.", description = "Save a single user to the database. The API automatically encrypts the password with BCrypt and generates an UUID.")
    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDTO user)
            throws InstanceAlreadyExistsException, InvalidEmailException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }


    @PreAuthorize("#username == authentication.principal.username || hasRole('TEACHER')")
    @Operation(summary = "Get an user by username.", description = "Receive a single user with all available Information by its username.")
    @GetMapping("/uname/{username}")
    public ResponseEntity<User> getByUsername(@Parameter(name = "Username", description = "Unique username of the user requested") @PathVariable String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER') || hasRole('STUDENT')")
    @Operation(summary = "Get an user by ID.", description = "Receive a single user with all available Information by its UUID.")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) throws InstanceNotFoundException {
        return new ResponseEntity<>(userService.findById(id).orElse(null), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Get students by subject id.", description = "Receive a list of students that are attending the given subject")
    @GetMapping("/subject/{id}")
    public ResponseEntity<List<User>> getUsersFromSubject(@PathVariable UUID id) throws InstanceNotFoundException {
        return new ResponseEntity<>(userService.findUsersBySubject(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Get students by class id.", description = "Receive a list of students that are attending the given class")
    @GetMapping("/class/{id}")
    public ResponseEntity<List<User>> getUsersFromClass(@PathVariable UUID id) throws InstanceNotFoundException {
        return new ResponseEntity<>(userService.findUsersByClass(id), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{username}/role/{rolename}")
    public ResponseEntity<String> addRoleToUser(@PathVariable("username") String username, @PathVariable("rolename") String rolename) {
        try {
            userService.addRoleToUser(username, rolename);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Parameter(description = "UUID of the user to change.") @PathVariable UUID id, @Valid @RequestBody User user) throws InstanceNotFoundException, InstanceAlreadyExistsException, InvalidEmailException {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Delete a user by ID.", description = "Delete a single user by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "UUID of the user to delete.") @PathVariable UUID id) throws InstanceNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Verify Login.")
    @GetMapping("/login/{username}/{pw}")
    public ResponseEntity<Boolean> verifyLogin(@PathVariable String username, @PathVariable String pw) throws InstanceNotFoundException {
        return new ResponseEntity<>(userService.verifyLogin(new LoginDTO(username, pw)), HttpStatus.OK);
    }

    @Operation(summary = "Get Role of user.")
    @GetMapping("/{username}/role")
    @PreAuthorize("#username == authentication.principal.username || hasRole('TEACHER')")
    public ResponseEntity<String> getRole(@PathVariable String username) throws InstanceNotFoundException {
        return new ResponseEntity<>(userService.getRoleByUsername(username), HttpStatus.OK);
    }


    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> handleInstanceAlreadyExistsException(InstanceAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
