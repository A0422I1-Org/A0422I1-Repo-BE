package com.example.demo.repository.account;

import com.example.demo.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<AccountRole, Integer> {
}
