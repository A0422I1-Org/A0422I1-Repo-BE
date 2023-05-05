package com.example.demo.dto.employee;

import com.example.demo.model.employee.Employee;
<<<<<<< HEAD
import com.example.demo.model.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
>>>>>>> 0c38633d66e7a01ae60b5357fdbeb7a928d75984

@AllArgsConstructor
@Getter
@Setter
public class EmployeeViewDTO {

    private String id;
    private String fullName;
    private String cardId;
    private String email;
    private String phoneNumber;
    private String address;

    public EmployeeViewDTO() {
    }

    public EmployeeViewDTO(Employee employee) {
        this.id=employee.getId();
        this.fullName=employee.getFullName();
        this.cardId=employee.getCardId();
        this.email=employee.getEmail();
        this.phoneNumber=employee.getPhoneNumber();
        this.address=employee.getAddress();
    };

}
