package com.codegym.demo.service.customer;

import com.codegym.demo.model.customer.Customer;

public interface ICustomerService {
    Customer findById(String customerId);
}
