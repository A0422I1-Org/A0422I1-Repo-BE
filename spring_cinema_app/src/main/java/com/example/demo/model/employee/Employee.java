package com.example.demo.model.employee;

import com.example.demo.model.account.Account;
import com.example.demo.model.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sun.awt.image.ImageWatched;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @Column(columnDefinition = ("varchar(45)"))
    private String id;
    @NotNull
    private String fullName;
    private String image;
    @NotNull
    private Boolean gender;
    @DateTimeFormat()
    @NotNull
    private Date birthday;
    @NotNull
    private String email;
    private Boolean isActivated;
    @NotNull
    @Column(columnDefinition = ("varchar(15)"))
    private String phoneNumber;
    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String address;
    @Column(columnDefinition = ("varchar(255)"))
    private String cardId;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @NotNull
    private Position position;

    private Boolean isDelete;

    public Employee() {
    }

    public Employee(String id, String fullName, String image, Boolean gender, Date birthday, String email, Boolean isActivated, String phoneNumber, String address, String cardId, Position position, Boolean isDelete) {
        this.id = id;
        this.fullName = fullName;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.isActivated = isActivated;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.position = position;
        this.isDelete = isDelete;
    }
}
