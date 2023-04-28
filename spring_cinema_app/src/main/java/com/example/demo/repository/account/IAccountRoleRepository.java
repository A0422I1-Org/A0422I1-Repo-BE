package com.example.demo.repository.account;

import com.example.demo.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRoleRepository extends JpaRepository<AccountRole,Integer> {
}
