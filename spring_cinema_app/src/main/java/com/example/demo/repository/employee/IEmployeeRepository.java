package com.example.demo.repository.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,String> {
}
