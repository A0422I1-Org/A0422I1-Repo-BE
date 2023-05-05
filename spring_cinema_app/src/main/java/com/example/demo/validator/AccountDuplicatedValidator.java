package com.example.demo.validator;

import com.example.demo.model.account.Account;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.validator.annotation.AccountDuplicated;
import jdk.internal.logger.BootstrapLogger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountDuplicatedValidator implements ConstraintValidator<AccountDuplicated, Account> {

    @Autowired
    private IAccountRepository accountRepository;


    @Override
    public void initialize(AccountDuplicated constraintAnnotation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Pham Trung Hieu
     * method: check whether account name is used
     * @param account
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Account account, ConstraintValidatorContext context) {
        Account databaseAccount = accountRepository.findAccountByUsername (account.getUsername());
        return databaseAccount == null || databaseAccount.getUsername().equals(account.getUsername());
    }
}
