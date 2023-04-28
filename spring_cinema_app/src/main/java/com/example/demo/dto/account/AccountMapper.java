package com.example.demo.dto.account;

import com.example.demo.model.account.Account;

public class AccountMapper {
    private static AccountMapper INSTANCE;

    public static AccountMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new AccountMapper();
        }
        return INSTANCE;
    }

    public Account toEntity(AccountDTO dto){
        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
//        account.setIsDelete(dto.getIsDelete());
//        account.setIsEnable(dto.getIsEnable());
//        account.setVerification_code(dto.getVerification_code());
        return account;
    }

    public AccountDTO toDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(account.getUsername());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setIsDelete(account.getIsDelete());
        accountDTO.setIsEnable(account.getIsEnable());
        accountDTO.setVerification_code(account.getVerification_code());
        return accountDTO;
    }
}
