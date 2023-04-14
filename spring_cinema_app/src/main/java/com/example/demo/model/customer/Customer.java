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
    private Integer phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private Integer cardId;

    @OneToOne
    @JoinColumn(name = "username")
    @NotNull
    private Account account;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "customers")
    @JsonBackReference
    private Set<Point> points;

    private Boolean isDelete;

    public Customer() {
    }

    public Customer(String id, @NotNull String fullName, @NotNull String gender, @NotNull Date birthday,
                    @NotNull String email, @NotNull Integer phoneNumber, @NotNull String address,
                    @NotNull Integer cardId,
                    @NotNull Account account, Set<Ticket> tickets, Set<Point> points, Boolean isDelete) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cardId = cardId;
        this.account = account;
        this.tickets = tickets;
        this.points = points;
        this.isDelete = isDelete;
    }
}
