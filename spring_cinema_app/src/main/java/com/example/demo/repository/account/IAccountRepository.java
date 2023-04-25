package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import com.example.demo.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE username = ?1")
    Account findAccountByUsername(String username);
}
