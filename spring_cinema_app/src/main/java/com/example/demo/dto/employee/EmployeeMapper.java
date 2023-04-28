package com.example.demo.dto.employee;

import com.example.demo.model.employee.Employee;
import sun.security.pkcs11.P11Util;

public class EmployeeMapper {
    private static EmployeeMapper INSTANCE;

    public static EmployeeMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new EmployeeMapper();
        }
        return INSTANCE;
    }

//    public Employee toEntity(EmployeeCreateDTO dto){
//        Employee employee = new Employee();
//        employee.setId(dto.getId());
//        employee.setAccount(dto.getUsername());
//        employee.setAddress(dto.getAddress());
//        employee.setEmail(dto.getEmail());
//        employee.setBirthday(dto.getBirthday());
//        employee.setCardId(dto.getCardId());
//        employee.setFullName(dto.getFullName());
//        employee.setGender(dto.getGender());
//        employee.setImage(dto.getImage());
//        employee.setPhoneNumber(dto.getPhoneNumber());
//        employee.setPosition(dto.getPosition());
//        return employee;
//    }

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setBirthday(employee.getBirthday());
        employeeDTO.setCardId(employee.getCardId());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setId(employee.getId());
        employeeDTO.setImage(employee.getImage());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setUsername(employee.getAccount());
        return employeeDTO;
    }
}
