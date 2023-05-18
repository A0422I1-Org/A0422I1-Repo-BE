package com.example.demo.model.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public Customer(String id, String fullName, Boolean gender, Date birthday, String email, String phoneNumber, String address, String cardId) {
    }

//    public Customer() {
//    }

//    public Customer(String id, String fullName, Boolean gender, Date birthday, String email, String phoneNumber, String address, String cardId, Account account, Boolean isDelete) {
//        this.id = id;
//        this.fullName = fullName;
//        this.gender = gender;
//        this.birthday = birthday;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.cardId = cardId;
//        this.account = account;
//        this.isDelete = isDelete;
//    }




//    public void setGetListPoint(List<Point> getListPoint) {
//        this.getListPoint = getListPoint;
//    }
//
//
//
//    public void setGetTicketList(List<Ticket> getTicketList) {
//        this.getTicketList = getTicketList;
//    }
//
//
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//
//
//    public void setGender(Boolean gender) {
//        this.gender = gender;
//    }
//
//
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//
//
//    public void setCardId(String cardId) {
//        this.cardId = cardId;
//    }
//
//
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//
//
//    public void setDelete(Boolean delete) {
//        isDelete = delete;
//    }
}

