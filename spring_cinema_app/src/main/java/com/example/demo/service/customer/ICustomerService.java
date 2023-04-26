package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;

public interface ICustomerService {
    Customer findById(String customerId);
}
