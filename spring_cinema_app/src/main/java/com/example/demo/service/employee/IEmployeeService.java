package com.example.demo.service.employee;

import com.example.demo.dto.employee.EmployeeCreateDTO;
import com.example.demo.dto.employee.EmployeeDTO;
import com.example.demo.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Employee addNewEmployee(Employee employee);
    Employee finEById(String id);
    public Iterable<Employee> findAll();
}
