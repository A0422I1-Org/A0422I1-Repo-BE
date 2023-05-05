package com.example.demo.service.impl.account;

import com.example.demo.model.account.Account;
import com.example.demo.model.employee.Employee;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;


    @Override
    public void addNewAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public String existsByEmployeeName(String username) {
        return accountRepository.existsByEmployeeName(username);
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }


}
