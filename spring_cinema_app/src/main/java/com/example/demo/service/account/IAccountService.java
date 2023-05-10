package com.example.demo.service.account;

import com.example.demo.model.account.Account;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

import java.io.UnsupportedEncodingException;

public interface IAccountService {

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
}
