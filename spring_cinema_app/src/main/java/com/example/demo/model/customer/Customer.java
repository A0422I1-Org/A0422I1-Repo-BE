package com.example.demo.model.customer;

import com.example.demo.model.account.Account;


import com.example.demo.model.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


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
    private Boolean gender;
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

    @OneToMany(mappedBy = "customers")
    @JsonIgnore
    private List<Point> getListPoint;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Ticket> getTicketList;

    public Customer() {
    }

    public Customer(String id, @NotNull String fullName, @NotNull Boolean gender, @NotNull Date birthday,
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


    public List<Point> getGetListPoint() {
        return getListPoint;
    }

    public void setGetListPoint(List<Point> getListPoint) {
        this.getListPoint = getListPoint;
    }

    public List<Ticket> getGetTicketList() {
        return getTicketList;
    }

    public void setGetTicketList(List<Ticket> getTicketList) {
        this.getTicketList = getTicketList;
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
