package com.example.demo.service.impl.account;

import com.example.demo.model.account.Account;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override

    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
