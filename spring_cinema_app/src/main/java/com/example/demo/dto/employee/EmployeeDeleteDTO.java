package com.example.demo.dto.employee;

import com.example.demo.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeDeleteDTO {
    private String id;
    private String fullName;
    private Date birthday;
    private Boolean gender;
    private String cardId;
    private String email;
    private String phoneNumber;
    private String address;
    private String image;

    public EmployeeDeleteDTO() {
    }

    public EmployeeDeleteDTO(Employee employee) {
        this.id=employee.getId();
        this.fullName=employee.getFullName();
        this.birthday=employee.getBirthday();
        this.gender=employee.getGender();
        this.cardId=employee.getCardId();
        this.email=employee.getEmail();
        this.phoneNumber=employee.getPhoneNumber();
        this.address=employee.getAddress();
        this.image=employee.getImage();
    };

}
