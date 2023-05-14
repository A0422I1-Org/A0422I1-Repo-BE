package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account,String> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE account SET password  = ?1 WHERE username = ?2")
    void updatePassword(String password, String username);


    /**
     * Pham Trung Hieu
     * @param username
     * @return account information
     */
    @Query(value = "select username, is_delete, is_enable, password, verification_code from account where username =?1", nativeQuery = true)
    Account findAccountByUsername(String username);

    /**
     * Pham Trung Hieu
     * @param username
     * @return username
     */
    @Query(value = "select username from account where username =?1", nativeQuery = true)
    String existsAccountByUsername(String username);

    /**
     * Pham Trung Hieu
     * @param code
     * @param username
     */
    @Modifying
    @Query(value ="update account set verification_code=?1 where username =?2",nativeQuery = true)
    void addVerificationCode(String code,String username);

    /**
     * Pham Trung Hieu
     * @param verifyCode
     * @return account information by verify code
     */
    @Query(value = "select username, is_delete, is_enable, password, verification_code from account where verification_code =?1",nativeQuery = true)
    Account findAccountByVerificationCode(String verifyCode);

    /**
     * Pham Trung Hieu
     * @param password
     * @param code
     */
    @Modifying
    @Query(value = "update account set password =?1,verification_code=null where verification_code=?2",nativeQuery = true)
    void saveNewPassword(String password, String code);

    Optional<Account> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "select username from account where username = ?1", nativeQuery = true)
    String existsByEmployeeName(String username);
    @Query(value = "select a from Account as a where a.username like %:userName%",nativeQuery = false)
    Account findByUsernameAccount(@Param("userName") String userName);
}
