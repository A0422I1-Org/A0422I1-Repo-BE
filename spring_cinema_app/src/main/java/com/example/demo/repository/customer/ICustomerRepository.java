package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ICustomerRepository  extends JpaRepository<Customer,String> {
    @Query(value = "select * from customer where username = ?1",nativeQuery = true)
    Customer findCustomerByUsername(String username);


    @Modifying
    @Query(value = "update customer set full_name = ?1, birthday = ?2, gender = ?3, card_id = ?4, email = ?5, address = ?6, phone_number = ?7 where id = ?8", nativeQuery = true)
    void updateCustomer(String fullName, Date birthday, Boolean gender, String carId, String email, String address, String phoneNumber, String id);
}
