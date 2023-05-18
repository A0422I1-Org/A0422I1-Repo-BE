package com.example.demo.service.account;
import com.example.demo.model.customer.Customer;
import org.springframework.stereotype.Service;
import com.example.demo.model.account.Account;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public interface IAccountService {
    /**
     * @method: edit customer
     * @author: DanhHC
     * @params: customer
     * @return: void
     */
    void updatePassword(Customer customer);



    /**
     * Pham Trung Hieu
     * @param username
     * @return account information
     */
    Account findAccountByUserName(String username);

    /**
     * Pham Trung Hieu
     * @param username
     * @return username
     */
    String existsAccountByUsername(String username);

    /**
     * Pham Trung Hieu
     * @param username
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;

    /**
     * Pham Trung Hieu
     * @param code
     * @return account status by verify code
     */
    Boolean findAccountByVerificationCodeToResetPassword(String code);

    /**
     * Pham Trung Hieu
     * @param code
     * @return account status by verify code
     */
    Boolean findAccountByVerificationCode(String code);

    /**
     * Pham Trung Hieu
     * @param password
     * @param code
     */
    void saveNewPassword(String password, String code);

    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);

    Account save(Account account);

    void addNewAccount(Account account);
    String existsByEmployeeName(String username);
    Account findAccountByUsername(String username);

}