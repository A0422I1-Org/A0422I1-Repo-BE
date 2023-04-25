package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Customer findCustomerById(String id);
    Page<Customer> searchCustomerByName(String name, Pageable pageable);
    void saveCustomer(Customer customer);
}
