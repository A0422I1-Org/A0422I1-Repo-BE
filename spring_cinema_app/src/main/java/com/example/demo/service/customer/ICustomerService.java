package com.example.demo.service.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findCustomerByAccount(Account account);

    Customer findById(String customerId);

}
