package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;

public interface ICustomerService {
    /**
     * Pham Trung Hieu
     * @param email
     * @return email
     */
    String existsByEmail(String email);
    Customer findById(String customerId);
    Customer findByUsername(String username);
    Customer getCustomerByAccount(String username);
}