package com.example.demo.repository.account;

import com.example.demo.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,String> {

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
    @Query(value = "select * from account where verification_code =?1",nativeQuery = true)
    Account findAccountByVerificationCode(String verifyCode);

    /**
     * Pham Trung Hieu
     * @param password
     * @param code
     */
    @Modifying
    @Query(value = "update account set password =?1,verification_code=null where verification_code=?2",nativeQuery = true)
    void saveNewPassword(String password, String code);
}
