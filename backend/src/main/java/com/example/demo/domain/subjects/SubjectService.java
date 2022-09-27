package com.example.demo.domain.subjects;

import com.example.demo.domain.appuser.User;
import com.example.demo.domain.role.Role;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubjectService {
    Subject saveSubject(Subject subject) throws InstanceAlreadyExistsException;
    Subject getSubject(String subjectName);
    Optional<Subject> findById(UUID id) throws InstanceNotFoundException;
    List<Subject> findAll();
    void deleteSubject(UUID id) throws InstanceNotFoundException;

    Subject updateSubject(UUID id, Subject subject) throws InstanceNotFoundException;

    List<Subject> findByUsername(String username);

    List<Subject> findByUserID(UUID id) throws AccessDeniedException;
}
