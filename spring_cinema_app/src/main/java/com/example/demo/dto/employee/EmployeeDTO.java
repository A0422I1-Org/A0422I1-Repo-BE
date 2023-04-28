package com.example.demo.dto.employee;

import com.example.demo.model.account.Account;
import com.example.demo.model.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String id;
    private String fullName;
    private String image;
    private Boolean gender;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String cardId;
    private Position position;
    private Account username;

    public EmployeeDTO() {
    }
}
