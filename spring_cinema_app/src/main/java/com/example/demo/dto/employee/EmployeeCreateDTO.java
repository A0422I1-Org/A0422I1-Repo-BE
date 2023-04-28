package com.example.demo.dto.employee;

import com.example.demo.model.account.Account;
import com.example.demo.model.account.AccountRole;
import com.example.demo.model.account.Role;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EmployeeCreateDTO {
//    private String id;
    private String fullName;
    private String image;
    private Boolean gender;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String cardId;
    private Position position;
    private String username;
    private String password;
//    private Role role;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public EmployeeCreateDTO() {
    }

    public EmployeeCreateDTO(String fullName, String image, Boolean gender, Date birthday, String email, String phoneNumber, String address, String cardId, Position position, String username, String password) {
        this.fullName = fullName;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.position = position;
        this.username = username;
        this.password = password;
    }
}
