package com.example.demo.service.account;

import com.example.demo.model.customer.Customer;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    void updatePassword(Customer customer);
}
