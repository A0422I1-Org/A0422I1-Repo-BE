package com.example.demo.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
public class Account {
    @Id
    @Column(columnDefinition = ("varchar(45)"))
    private String username;
    @Column(columnDefinition = ("varchar(255)"))
    private String password;
    private Boolean isDelete;
    private Boolean isEnable;
    @Column(columnDefinition = ("varchar(255)"))
    private String verification_code;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<AccountRole> accountRoleList;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password, Boolean isDelete, Boolean isEnable, String verification_code, Set<AccountRole> accountRoleList) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
        this.isEnable = isEnable;
        this.verification_code = verification_code;
        this.accountRoleList = accountRoleList;
    }
}
