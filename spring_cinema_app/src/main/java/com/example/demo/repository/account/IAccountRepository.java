package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAccountRepository extends JpaRepository<Account,String> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE account SET password  = ?1 WHERE username = ?2")
    void updatePassword(String password, String username);
}
