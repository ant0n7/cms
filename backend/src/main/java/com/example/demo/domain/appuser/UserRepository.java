package com.example.demo.domain.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername (String username);

    @Query(value = "select class_id  from tbl_class_subjects tcs where tcs.subject_id = :subjectUUID", nativeQuery = true)
    List<String> getClassesBySubject(@Param("subjectUUID") UUID subjectUUID);

    @Query(value = "select cast(member_id AS varchar) from tbl_class_members tcm where tcm.class_id = :classUUID", nativeQuery = true)
    List<String> getUsersByClass(@Param("classUUID") UUID classUUID);

    @Query(value = "select cast(user_id AS varchar) from tbl_user_role tur join tbl_role tr on tur.role_id = tr.id where tr.rolename = 'STUDENT'", nativeQuery = true)
    List<String> findAllStudents();

    @Query(value = "select cast(user_id AS varchar) from tbl_user_role tur join tbl_role tr on tur.role_id = tr.id where tr.rolename = 'TEACHER'", nativeQuery = true)
    List<String> findAllTeachers();

    @Query(value = "select tr.rolename from tbl_role tr where id = (select role_id from tbl_user_role tur where user_id = (select id from tbl_user tu where username = :username))", nativeQuery = true)
    String getRole(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "delete from tbl_class_members where member_id = :user", nativeQuery = true)
    int deleteFromClass(@Param("user") UUID user);

    @Query("delete from tbl_user where id ='2c61dac7-29fa-4baa-95e5-9053c7879d41'")
    Integer deleteUser(UUID user);

    User findByEmail(String email);
}
