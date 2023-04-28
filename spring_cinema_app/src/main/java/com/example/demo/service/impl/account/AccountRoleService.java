package com.example.demo.service.impl.account;

import com.example.demo.model.account.AccountRole;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.repository.account.IAccountRoleRepository;
import com.example.demo.service.account.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleService implements IAccountRoleService {
    @Autowired
    private IAccountRoleRepository accountRoleRepository;
    @Override
    public void addAccountRole(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }
}
