package com.example.demo.model.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @Column(columnDefinition = ("varchar(45)"))
    private String id;
    @NotNull
    private String fullName;
    @NotNull
    private String gender;
    @DateTimeFormat()
    @NotNull
    private Date birthday;
    @NotNull
    private String email;
    @NotNull
    @Column(columnDefinition = ("varchar(15)"))
    private String phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private String cardId;

    @OneToOne
    @JoinColumn(name = "username")
    @NotNull
    private Account account;

    private Boolean isDelete;

    public Customer() {
    }

    public Customer(String id, @NotNull String fullName, @NotNull String gender, @NotNull Date birthday,
                    @NotNull String email, @NotNull String phoneNumber, @NotNull String address,
                    @NotNull String cardId,
                    @NotNull Account account, Boolean isDelete) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.account = account;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
