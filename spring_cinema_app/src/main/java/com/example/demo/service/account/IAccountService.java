package com.example.demo.service.account;
import com.example.demo.model.account.Account;
import com.example.demo.model.employee.Employee;

import java.util.Optional;

public interface IAccountService {
    void addNewAccount(Account account);
    String existsByEmployeeName(String username);
    Optional<Account> findAccountByUsername(String username);

    public void updatePass(Employee employee);
}
