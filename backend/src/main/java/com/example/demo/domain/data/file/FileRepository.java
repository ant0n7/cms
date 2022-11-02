package com.example.demo.domain.data.file;

import com.example.demo.domain.data.employee.Employee;
import com.example.demo.domain.data.employee.fields.EmployeeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author anton
 * @since 11/2/2022, Wed
 **/

@Repository
public interface FileRepository extends JpaRepository<EmployeeImage, UUID> {
//    EmployeeImage findBy
}
