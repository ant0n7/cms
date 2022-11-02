package com.example.demo.domain.data.employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface EmployeeService {
  List<Employee> findAll();
  boolean setFileCodeForEmployeeId(UUID employeeId, String filecode);
  Employee getEmployeeById(UUID id) throws NoSuchElementException;
  String getImageIdByEmployeeId(UUID employeeId);
  boolean updateEmployee(UUID id, Employee employee);
  Employee createEmployee(Employee employee);
  void delete(UUID id);
}
