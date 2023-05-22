package com.example.demo.service.impl.employee;

import com.example.demo.error.NotFoundById;
import com.example.demo.model.employee.Employee;
import com.example.demo.repository.employee.IEmployeeRepository;
import com.example.demo.service.employee.IEmployeeService;
import lombok.SneakyThrows;
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
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @SneakyThrows
    public Employee findById(String id) throws NotFoundById {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
       throw new NotFoundById("khong tim thay"+ id);
    }


    @Override
    public Integer updateIsDeleteById(String id) {
        return employeeRepository.updateIsDeleteById(id);
    }


    @Override
    public Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId, Pageable pageable) {
        if(positionId<0)
            return employeeRepository.findAllByFullNameContaining(name.trim(),pageable);

        return employeeRepository.findAllByFullNameContainingAndPosition(name.trim(),positionId,pageable);
    }

    @Override
    public Employee findEmployeeByUsername(String username) {
        return employeeRepository.findEmployeeByUsername(username);
    }

    /**
     * Tay
     */
    @Override
    public String existsByEmployeeEmail(String email) {
        return employeeRepository.existsByEmployeeEmail(email);
    }
    /**
     * Tay
     */
    @Override
    public String existsByEmployeePhoneNumber(String phoneNumber) {
        return employeeRepository.existsByEmployeePhoneNumber(phoneNumber);
    }

    @Override
    public String existsByEmployeeCardId(String cardId) {
        return employeeRepository.existsByEmployeeCardId(cardId);
    }


}
