package com.example.demo.service.impl.customer;

<<<<<<< HEAD
=======
import com.example.demo.model.account.Account;
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
<<<<<<< HEAD
    ICustomerRepository customerRepository;

    public List<Customer> findAll(){
      return  customerRepository.findAll();
=======
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomerByAccount(Account account) {
        return iCustomerRepository.findCustomerByAccount(account.getUsername());
    }

    @Override
    public Customer findById(String customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
    }
}
