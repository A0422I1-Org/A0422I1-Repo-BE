package com.example.demo.dto.employee;

import com.example.demo.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeViewDTO {

    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;

    public EmployeeViewDTO() {
    }

    public EmployeeViewDTO(Employee employee) {
        this.id=employee.getId();
        this.fullName=employee.getFullName();
        this.email=employee.getEmail();
        this.phoneNumber=employee.getPhoneNumber();
    };

}
