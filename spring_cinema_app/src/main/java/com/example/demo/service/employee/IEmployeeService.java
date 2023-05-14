package com.example.demo.service.employee;


import com.example.demo.error.NotFoundById;
import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Employee addNewEmployee(Employee employee);
    Employee findById(String id) throws NotFoundById;

    Integer updateIsDeleteById(String id);

    Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId, Pageable pageable);
}
