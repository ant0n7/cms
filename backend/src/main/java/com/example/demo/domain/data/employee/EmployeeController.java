package com.example.demo.domain.data.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin
@RestController
@RequestMapping("/api/data/employees")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  // Test ResponseEntity endpoint
  // http://localhost:8080/api/data/employees/test
  @GetMapping("/test")
  public ResponseEntity<String> test() {
    return new ResponseEntity<>("Success.", HttpStatus.OK);
  }
  
  @GetMapping({"/", ""})
  public ResponseEntity<List<Employee>> findAll() {
    return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
  }
}
