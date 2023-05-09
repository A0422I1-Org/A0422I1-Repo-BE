package com.example.demo.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String name;
    private Boolean isDelete;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<AccountRole> accountRoleList;

    public Role() {
    }

    public Role(Integer id, String name, Boolean isDelete, Set<AccountRole> accountRoleList) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.accountRoleList = accountRoleList;
    }
}
