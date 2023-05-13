package com.example.demo.service.impl.account;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.service.account.IAccountService;
import com.example.demo.model.account.Account;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void updatePassword(Customer customer) {
        this.accountRepository.updatePassword(customer.getAccount().getPassword(), customer.getAccount().getUsername());
    }

    /**
     * Pham Trung Hieu
     * @param username
     * @return account information
     */
    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    /**
     * Pham Trung Hieu
     * @param username
     * @return username
     */
    @Override
    public String existsAccountByUsername(String username) {
        return accountRepository.existsAccountByUsername(username);
    }

    /**
     * Pham Trung Hieu
     * @param username
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    @Override
    public void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException {
        String code = RandomString.make(20);
        accountRepository.addVerificationCode(code, username);
    }

    /**
     * Pham Trung Hieu
     * @param code
     * @return account status by verify code
     */
    @Override
    public Boolean findAccountByVerificationCodeToResetPassword(String code) {
        Account account = accountRepository.findAccountByVerificationCode(code);
        return account != null;
    }

    /**
     * Pham Trung Hieu
     * @param code
     * @return account status by verify code
     */
    @Override
    public Boolean findAccountByVerificationCode(String code) {
        Account account = accountRepository.findAccountByVerificationCode(code);
        if (account == null || account.getEnable()) {
            return false;
        } else {
            account.setEnable(true);
            account.setVerificationCode(null);
            accountRepository.save(account);
            return true;
        }
    }

    /**
     * Pham Trung Hieu
     * @param password
     * @param code
     */
    @Override
    public void saveNewPassword(String password, String code) {
        accountRepository.saveNewPassword(password, code);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

}