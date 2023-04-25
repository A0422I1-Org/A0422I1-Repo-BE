package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String> {

    @Query(nativeQuery = true, value = "SELECT * FROM customer c WHERE id = ?1")
    Customer findCustomerById(String id);

    @Query(nativeQuery = true, value = "SELECT * FROM customer WHERE full_name LIKE CONCAT('%',?1,'%')")
    Page<Customer> searchCustomerByName(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "UPDATE customer SET full_name = ?2, birthday = ?3, gender = ?4," +
            "email =5, card_id = 6, phone_number = ?7, address = ?8 WHERE id = ?1, " +
            "UPDATE account SET password = ?9 WHERE username = ?10")
    void updateCustomer(String id, String fullName, Date birthday, boolean gender, String email,
                        String cardId, String phoneNumber, String address, String password, String username);

}
