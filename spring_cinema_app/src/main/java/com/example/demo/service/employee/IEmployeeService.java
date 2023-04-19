package com.example.demo.service.employee;


import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findById(String id);

    void remove(String id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByFullNameContaining(String name,Pageable pageable);

    Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId,Pageable pageable);
}
