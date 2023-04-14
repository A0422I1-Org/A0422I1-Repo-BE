package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String> {
}
