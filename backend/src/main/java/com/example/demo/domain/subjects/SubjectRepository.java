package com.example.demo.domain.subjects;

import com.example.demo.domain.appuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    Subject findBySubjectname (String subjectName);

    @Query(value = "select cast(class_id as varchar)  from tbl_class_members tcs where tcs.member_id = :userID", nativeQuery = true)
    List<String> getClassesByUser(@Param("userID") UUID userID);

    @Query(value = "select cast(subject_id AS varchar) from tbl_class_subjects tcm where tcm.class_id = :classUUID", nativeQuery = true)
    List<String> getSubjectsByClass(@Param("classUUID") UUID classUUID);
}
