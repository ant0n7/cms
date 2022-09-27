package com.example.demo.domain.appclass;

import com.example.demo.domain.appclass.dto.CreateClassDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classes")
public class ClassController {
    private final ClassService classService;

    @PreAuthorize("hasRole('TEACHER') || hasRole('ADMIN') || hasRole('STUDENT')")
    @Operation(summary = "Get all classes.", description = "Retrieve a list of all classes")
    @GetMapping("/")
    public ResponseEntity<Collection<Class>> findAllClasses() {
        return new ResponseEntity<>(classService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER') || hasRole('STUDENT') ")
    @Operation(summary = "Get a class by ID.", description = "Retrieve a the class with the corresponding ID")
    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassByID(@PathVariable UUID id) throws InstanceNotFoundException {
        return new ResponseEntity<>(classService.findById(id).orElse(null), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Add a class.", description = "Add a single class.")
    @PostMapping("/")
    public ResponseEntity<Class> addClass(@Valid @RequestBody CreateClassDTO appclass) throws InstanceAlreadyExistsException, InstanceNotFoundException {
        return new ResponseEntity<>(classService.saveClass(appclass), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update a subject by ID.", description = "Update a single subject by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable UUID id, @Valid @RequestBody Class appclass) throws InstanceNotFoundException {
        return new ResponseEntity<>(classService.updateClass(id, appclass), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Delete a subject by ID.", description = "Delete a single subject by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable UUID id) throws InstanceNotFoundException {
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Add a member to a class.", description = "Add a member (either student or teacher) to a class")
    @PutMapping("/{classID}/{userID}")
    public ResponseEntity<String> addUserToClass(@PathVariable UUID classID, @PathVariable UUID userID) throws InstanceNotFoundException {
        classService.addUserToClass(classID, userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Add a subject to a class.", description = "Add a subject to a class")
    @PutMapping("/{classID}/{subjectID}")
    public ResponseEntity<String> addSubjectToClass(@PathVariable UUID classID, @PathVariable UUID subjectID) throws InstanceNotFoundException {
        classService.addSubjectToClass(classID, subjectID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PreAuthorize("#username == authentication.principal.username || hasRole('TEACHER')")
//    @Operation(summary = "Get classes by username.", description = "Receive a list of classes that the given user attends")
//    @GetMapping("/user/{username}")
//    public ResponseEntity<List<RestrictedClassInformationDTO>> getClassesFromUsername(@PathVariable String username) throws InstanceNotFoundException {
//        return new ResponseEntity<>(classService.findClassesByUsername(username), HttpStatus.OK);
//    }

    @Operation(summary = "Get classes by user.", description = "Receive a list of classes that the given user attends")
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Class>> getClassesFromUserID(@PathVariable UUID id) throws InstanceNotFoundException, AccessDeniedException {
        return new ResponseEntity<>(classService.findClassesByUserID(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Get classes by subjectname.", description = "Receive a list of classes that the given subject is part of")
    @GetMapping("/subject/{id}")
    public ResponseEntity<List<Class>> getClassesFromSubjectID(@PathVariable UUID id) throws InstanceNotFoundException {
        return new ResponseEntity<>(classService.findClassesBySubjectID(id), HttpStatus.OK);
    }



}
