package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String> {

    @Query("select c. from Customer c left join point p on p.customer_id = c.id ")
    List<Customer> findAllCustomer();
}
