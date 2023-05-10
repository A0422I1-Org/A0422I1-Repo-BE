package com.example.demo.service.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;

import java.util.Optional;

public interface ICustomerService {

    Customer findCustomerByAccount(Account account );

    void save(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerByUsername(String username);
    Optional<Customer> findById(String id);
}
