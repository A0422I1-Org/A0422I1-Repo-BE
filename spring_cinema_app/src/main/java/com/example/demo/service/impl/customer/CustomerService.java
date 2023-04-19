package com.example.demo.service.impl.customer;


import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomerByAccount(Account account) {
        return null;
    }

    @Override
    public Customer findById(String customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
    }

    public List<?> getListCustomerPoint() {
        return iCustomerRepository.getListCustomerPoint();
    }

    public List<?> getListCustomerTicket() {
        return iCustomerRepository.getListCustomerTicket();
    }

}
