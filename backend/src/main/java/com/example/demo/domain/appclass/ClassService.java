package com.example.demo.domain.appclass;

import com.example.demo.domain.appclass.dto.CreateClassDTO;
import com.example.demo.domain.appclass.dto.RestrictedClassInformationDTO;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassService {
    Class saveClass(CreateClassDTO appclass) throws InstanceAlreadyExistsException, InstanceNotFoundException;
    Optional<Class> findById(UUID id) throws InstanceNotFoundException;
    List<Class> findAll();
    void deleteClass(UUID id) throws InstanceNotFoundException;
    Class updateClass(UUID id, Class appclass) throws InstanceNotFoundException;

    void addUserToClass(UUID classid, UUID userid) throws InstanceNotFoundException;

    void addSubjectToClass(UUID classID, UUID subjectID) throws InstanceNotFoundException;
    List<RestrictedClassInformationDTO> findRestrictedClassesByUsername(String username) throws InstanceNotFoundException;

    List<Class> findClassesByUsername(String username) throws InstanceNotFoundException;


    List<Class> findClassesByUserID(UUID id) throws InstanceNotFoundException, AccessDeniedException;

    List<Class> findClassesBySubject(String subjectname) throws InstanceNotFoundException;

    List<Class> findClassesBySubjectID(UUID id) throws InstanceNotFoundException;
}
