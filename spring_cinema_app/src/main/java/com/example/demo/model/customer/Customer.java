package com.example.demo.model.customer;

import com.example.demo.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
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


}
