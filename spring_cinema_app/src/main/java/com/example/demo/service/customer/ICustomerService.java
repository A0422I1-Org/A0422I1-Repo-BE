package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;

import java.util.Optional;

public interface ICustomerService {
//    Customer findById(String customerId);
    void save(Customer customer);
    void remove(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerByUsername(String username);
    Optional<Customer> findById(String id);
}
