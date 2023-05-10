package com.example.demo.service.account;

import com.example.demo.model.account.Account;

public interface IAccountService {

    Account findByUsername(String username);
    void save(Account account);
    String existsByUserName(String username);
    String existsByPassword(String username, String password);
    void saveNewPassword(String password,String username);
}
