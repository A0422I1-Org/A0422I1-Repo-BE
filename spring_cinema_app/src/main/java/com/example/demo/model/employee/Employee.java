package com.example.demo.model.employee;

import com.example.demo.model.account.Account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @OneToOne
    @JoinColumn(name = "username")
    @NotNull
    private Account account;


    private Boolean isDelete;

    public Employee() {
    }


    public Employee(String id, @NotNull String fullName, String image, @NotNull Boolean gender, @NotNull Date birthday,
                    @NotNull String email, @NotNull Boolean isActivated, @NotNull String phoneNumber,

                    @NotNull String address, String cardId, @NotNull Position position, @NotNull Account account,
                    Boolean isDelete) {
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
        this.account = account;
        this.isDelete = isDelete;
    }
}
