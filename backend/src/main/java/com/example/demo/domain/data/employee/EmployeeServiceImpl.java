package com.example.demo.domain.data.employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.transaction.Transactional;

import com.example.demo.domain.data.employee.fields.EmployeeImage;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public boolean setFileCodeForEmployeeId(UUID employeeId, String filecode) {
    Employee employee = employeeRepository.getById(employeeId);

    if (employee.getImage() == null) {
      employee.setImage(new EmployeeImage(filecode));
    } else {
      employee.getImage().setId(filecode);
    }

    // Save data & check if data is persisted
    return filecode.equals(employeeRepository.save(employee).getImage().getId());
  }

  @Override
  public Employee getEmployeeById(UUID id) throws NoSuchElementException {
    return employeeRepository.findById(id).orElseThrow();
  }

  @Override
  public String getImageIdByEmployeeId(UUID employeeId) throws NoSuchElementException {
    Employee employee = getEmployeeById(employeeId);

    if (employee.getImage() != null) {
      return employee.getImage().getId();
    }

    return "uzPFIDsZ"; // default picture
//    throw new NoSuchElementException();
  }
}
