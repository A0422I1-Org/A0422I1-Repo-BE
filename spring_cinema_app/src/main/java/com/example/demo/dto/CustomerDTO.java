package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String fullName;
    private Boolean gender;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String cardId;
    private String username;
    private String password;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String fullName, Boolean gender, Date birthday, String email, String phoneNumber, String address, String cardId, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.username = username;
        this.password = password;
    }
}
