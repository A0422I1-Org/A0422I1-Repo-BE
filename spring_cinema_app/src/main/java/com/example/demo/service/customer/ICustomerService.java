package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Customer findCustomerById(String id);
    Page<Customer> searchCustomerByName(String name, Pageable pageable);
    void saveCustomer(Customer customer);
    void save(Customer customer);

    /**
     * Pham Trung Hieu
     * @param email
     * @return email
     */
    String existsByEmail(String email);

    Customer findById(String customerId);

    Customer getCustomerByAccount(String username);

}
