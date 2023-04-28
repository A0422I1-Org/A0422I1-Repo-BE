package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Page<Customer> searchCustomerByName(String name, Pageable pageable) {
        return customerRepository.searchCustomerByName(name, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
       customerRepository.updateCustomer(customer.getId(), customer.getFullName(), customer.getBirthday(), customer.getGender(),
                customer.getEmail(), customer.getCardId(), customer.getPhoneNumber(), customer.getAddress());
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}