package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer(Pageable pageable);
    Customer findCustomerById(String id);
    List<Customer> searchCustomerByName(String name, Pageable pageable);
    void saveCustomer(Customer customer);
}
