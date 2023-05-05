package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import com.example.demo.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account,String> {
    @Query(value = "select username from account where username = ?1", nativeQuery = true)
    String existsByEmployeeName(String username);
    @Query(value = "select a from Account as a where a.username like %:userName%",nativeQuery = false)
    Account findByUsername(@Param("userName") String userName);

}
