package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String> {
    /**
     * Pham Trung Hieu
     * @param email
     * @return email to reset password
     */
    @Query(value = "select email from customer where email =?1", nativeQuery = true)
    String existsByEmail(String email);
    @Query(value = "select * from customer where username = ?", nativeQuery = true)
    Customer findCustomerByUsername(String username);
}
