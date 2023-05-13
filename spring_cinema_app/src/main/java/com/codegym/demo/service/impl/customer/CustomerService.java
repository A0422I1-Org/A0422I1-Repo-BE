package com.codegym.demo.service.impl.customer;


import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.repository.customer.ICustomerRepository;
import com.codegym.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findById(String customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
    }
}
