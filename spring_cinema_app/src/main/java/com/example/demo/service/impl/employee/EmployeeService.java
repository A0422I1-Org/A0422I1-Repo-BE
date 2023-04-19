package com.example.demo.service.impl.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.repository.employee.IEmployeeRepository;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }


    @Override
    public void remove(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByFullNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByFullNameContaining(name,pageable);
    }

    @Override
    public Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId, Pageable pageable) {
        if(positionId<0)
            return employeeRepository.findAllByFullNameContaining(name,pageable);

        return employeeRepository.findAllByFullNameContainingAndPosition(name,positionId,pageable);
    }


}
