package com.example.demo.dto.account;

import com.example.demo.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String username;
    private String password;
    private Boolean isDelete;
    private Boolean isEnable;
    private String verification_code;

    public AccountDTO() {
    }
}
