package com.example.demo.repository.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface ICustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findCustomerByFullNameContaining(String name);

    /**
     * Pham Trung Hieu
     * @param email
     * @return email to reset password
     */
    @Query(value = "select email from customer where email =?1", nativeQuery = true)
    String existsByEmail(String email);

    Customer getCustomerByAccount(@Param("username")String username);

}
