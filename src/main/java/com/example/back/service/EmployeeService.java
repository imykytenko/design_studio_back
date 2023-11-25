package com.example.backend_.service;

import com.example.backend_.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee add(Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);

    Employee update(Employee employee);
}
