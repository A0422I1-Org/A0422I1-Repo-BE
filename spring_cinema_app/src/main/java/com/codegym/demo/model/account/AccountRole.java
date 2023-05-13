package com.codegym.demo.model.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "username")
    @NotNull
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull
    private Role role;

    private Boolean isDelete;

    public AccountRole() {
    }

    public AccountRole(Integer id, @NotNull Account account, @NotNull Role role, Boolean isDelete) {
        this.id = id;
        this.account = account;
        this.role = role;
        this.isDelete = isDelete;
    }
}
