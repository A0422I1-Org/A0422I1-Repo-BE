package com.example.demo.service.employee;


import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findById(String id);

    void remove(String id);

    List<Employee> findAll();

    List<Employee> findAllByFullNameContaining(String name);

    List<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId);
}
