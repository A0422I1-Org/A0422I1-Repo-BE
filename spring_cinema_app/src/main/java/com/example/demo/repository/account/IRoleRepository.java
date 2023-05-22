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

    /**
     * Pham Trung Hieu -> set new account for role = customer
     * @param username
     * @param roleId
     */
    @Modifying
    @Query(value = "insert into account_role(username, is_delete, role_id) values (?1,?2, ?3)", nativeQuery = true)
    void setDefaultRole(String username, boolean isDelete, Integer roleId);

    @Query(value = "select name from role where id = ?1", nativeQuery = true)
    String getRole(int roleId);
}
