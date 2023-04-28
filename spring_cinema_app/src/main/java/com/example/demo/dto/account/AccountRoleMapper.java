package com.example.demo.dto.account;

import com.example.demo.model.account.AccountRole;

public class AccountRoleMapper {
    private static AccountRoleMapper INSTANCE;

    public static AccountRoleMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new AccountRoleMapper();
        }
        return INSTANCE;
    }

    public AccountRole toEntity(AccountRoleDTO dto){
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(dto.getAccount());
        accountRole.setRole(dto.getRole());
        return accountRole;
    }

    public AccountRoleDTO toDTO(AccountRole accountRole){
        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        accountRoleDTO.setAccount(accountRoleDTO.getAccount());
        accountRoleDTO.setRole(accountRoleDTO.getRole());
        return accountRoleDTO;
    }
}
