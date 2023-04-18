package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface ICustomerRepository  extends JpaRepository<Customer,String> {

//    @Query("select c. from Customer c left join point p on p.customer_id = c.id ")
//    List<Customer> findAllCustomer();
=======
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(nativeQuery = true, value = "select id, address, birthday, card_id, email, full_name, gender, is_delete, phone_number, username from customer where username = ?")
    Customer findCustomerByAccount(String account);
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
}
