package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public String existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

}
