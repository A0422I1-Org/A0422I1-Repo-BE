package com.example.demo.model.account;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Account {
    @Id
    @Column(columnDefinition = ("varchar(45)"))
    private String username;
    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String password;
    @NotNull
    private Boolean isDelete;
    @NotNull
    private Boolean isEnable;
    @Column(columnDefinition = ("varchar(255)"))
    private String verificationCode;

    public Account() {
    }

    public Account(String username, String password, Boolean isDelete, Boolean isEnable, String verificationCode) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
        this.isEnable = isEnable;
        this.verificationCode = verificationCode;
    }
}
