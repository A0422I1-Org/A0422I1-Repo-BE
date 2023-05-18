package com.example.demo.service.impl.account;

import com.example.demo.model.account.Account;
import com.example.demo.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtAccountDetailServiceImpl implements UserDetailsService {

    @Autowired
    IAccountRepository accountRepository;

    /**
     * Pham Trung Hieu
     * @param username the username identifying the user whose data is required.
     * @return check user has existed
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return JwtAccountDetailsImpl.build(account);
    }
}
