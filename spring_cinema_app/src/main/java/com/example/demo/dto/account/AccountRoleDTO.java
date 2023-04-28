package com.example.demo.dto.account;

import com.example.demo.model.account.Account;
import com.example.demo.model.account.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AccountRoleDTO {
    private Account account;
    private Role role;

    public AccountRoleDTO() {
    }
}
