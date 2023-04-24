package com.example.demo.service.impl.account;

import com.example.demo.model.account.Account;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public String existsByUserName(String username) {
        return accountRepository.existsByUserName(username);
    }

    @Override
    public String existsByPassword(String username, String password) {
        return accountRepository.existsByPassword(username, password);
    }

    @Override
    public void saveNewPassword(String password, String username) {
        accountRepository.saveNewPassword(password, username);
    }
}
