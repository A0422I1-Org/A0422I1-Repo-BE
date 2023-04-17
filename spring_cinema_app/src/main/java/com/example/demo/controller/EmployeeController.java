package com.example.demo.controller;

import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> saveCustomer(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee){
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if (!employeeOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setId(employeeOptional.get().getId());
        return new ResponseEntity<>(employeeService.addNewEmployee(employee),HttpStatus.OK);
    }
}
