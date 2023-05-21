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
    private String verificationCode;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<AccountRole> accountRoleList;


    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password, Boolean isDelete, Boolean isEnable, String verificationCode, Set<AccountRole> accountRoleList) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
        this.isEnable = isEnable;
        this.verificationCode = verificationCode;
        this.accountRoleList = accountRoleList;
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

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<AccountRole> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(Set<AccountRole> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }
}