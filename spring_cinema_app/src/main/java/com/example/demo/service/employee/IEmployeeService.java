package com.example.demo.service.employee;

import com.example.demo.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee addNewEmployee(Employee employee);
    Optional<Employee> findEmployeeById(String id);
}
