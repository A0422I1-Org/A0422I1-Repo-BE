package com.example.demo.service.employee;

<<<<<<< HEAD
import com.example.demo.dto.employee.EmployeeCreateDTO;
import com.example.demo.dto.employee.EmployeeDTO;
import com.example.demo.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Employee addNewEmployee(Employee employee);
    Employee finEById(String id);
    public Iterable<Employee> findAll();
=======

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Employee findById(String id);

    Integer updateIsDeleteById(String id);

    Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId,Pageable pageable);
>>>>>>> 0c38633d66e7a01ae60b5357fdbeb7a928d75984
}
