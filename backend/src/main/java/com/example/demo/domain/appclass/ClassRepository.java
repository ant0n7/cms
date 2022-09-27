package com.example.demo.domain.appclass;

import com.example.demo.domain.subjects.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassRepository extends JpaRepository<Class, UUID> {
    Class findByClassname (String classname);

    @Query(value = "select CAST(class_id as varchar) from tbl_class_members tcm where member_id = :userUUID", nativeQuery = true)
    List<String> findClassesByUser (@Param("userUUID") UUID userUUID);

    @Query(value = "select CAST(class_id as varchar) from tbl_class_subjects tcm where subject_id = :subjectID", nativeQuery = true)
    List<String> findClassesBySubject (@Param("subjectID") UUID subjectID);

}
