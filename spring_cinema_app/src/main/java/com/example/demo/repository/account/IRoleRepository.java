package com.example.demo.repository.account;

import com.example.demo.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<AccountRole, Integer> {
    @Modifying
    @Query(value = "insert into account_role(account_username,role_id) values (?1,?2)", nativeQuery = true)
    void setDefaultRole(String username, Integer roleId);
}
