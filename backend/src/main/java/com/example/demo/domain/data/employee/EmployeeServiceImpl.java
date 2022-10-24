package com.example.demo.domain.data.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }
}
