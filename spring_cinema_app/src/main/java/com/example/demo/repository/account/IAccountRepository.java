package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

    @Query(nativeQuery = true, value = "select username, is_delete, is_enable, password, verification_code from account where username = ?")
    Account findByUsername(String username);
}
