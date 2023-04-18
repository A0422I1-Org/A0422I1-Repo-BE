package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override

    public List<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.getAllCustomer(pageable);
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name, Pageable pageable) {
        return customerRepository.searchCustomerByName(name, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getId(), customer.getFullName(), customer.getBirthday(), customer.isGender(),
                customer.getEmail(), customer.getCardId(), customer.getPhoneNumber(), customer.getAddress(),
                customer.getAccount().getPassword(), customer.getAccount().getUsername());
    }
}