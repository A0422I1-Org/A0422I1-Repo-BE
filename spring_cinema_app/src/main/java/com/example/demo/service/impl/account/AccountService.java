package com.example.demo.service.impl.account;

import com.example.demo.model.customer.Customer;
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
    public void updatePassword(Customer customer) {
        this.accountRepository.updatePassword(customer.getAccount().getPassword(), customer.getAccount().getUsername());
    }
}
