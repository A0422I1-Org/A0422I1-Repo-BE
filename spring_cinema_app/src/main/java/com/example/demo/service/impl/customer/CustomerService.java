package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

//    @Override
//    public Customer findById(String customerId) {
//        return iCustomerRepository.findById(customerId).orElse(null);
//    }

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getFullName(), customer.getBirthday(), customer.getGender(), customer.getCardId(),
                customer.getEmail(), customer.getAddress(), customer.getPhoneNumber(), customer.getId());
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }
}
