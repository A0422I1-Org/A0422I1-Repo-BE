package com.example.demo.service.impl.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.repository.employee.IEmployeeRepository;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(String id) {
        return employeeRepository.findById(id);
    }
}
