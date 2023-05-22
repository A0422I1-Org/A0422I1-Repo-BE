package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface ICustomerRepository  extends JpaRepository<Customer,String> {

    @Query(nativeQuery = true, value = "SELECT id, address, birthday, card_id, email, full_name, gender," +
            "is_delete, phone_number, username FROM customer c WHERE id = ?1")
    Customer findCustomerById(String id);

    @Query(nativeQuery = true, value = "SELECT * FROM customer " +
            "WHERE full_name LIKE CONCAT('%',?1,'%') OR phone_number LIKE CONCAT('%',?1,'%') " +
            "OR card_id LIKE CONCAT('%',?1,'%') OR email LIKE CONCAT('%',?1,'%')")
    Page<Customer> searchCustomerByName(String name, Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customer SET full_name = ?2, birthday = ?3, gender = ?4," +
            "email = ?5, card_id = ?6, phone_number = ?7, address = ?8 WHERE id = ?1")
    void updateCustomer(String id, String fullName, Date birthday, boolean gender, String email,
                        String cardId, String phoneNumber, String address);

    /**
     * Pham Trung Hieu
     * @param id
     * @param fullName
     * @param email
     * @param username
     */
    @Modifying
    @Query(value = "insert into customer(id, full_name, email, username) values (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveCustomerLoginWithGoogle(String id, String fullName, String email, String username);

    /**
     * Pham Trung Hieu
     * @param email
     * @return email to reset password
     */
    @Query(value = "select email from customer where email =?1", nativeQuery = true)
    String existsByEmail(String email);

    /**
     * Pham Trung Hieu
     * @param username
     * @return customer
     */
    Customer getCustomerByAccount(@Param("username")String username);



    @Query(value = "select * from customer where username = ?", nativeQuery = true)
    Customer findCustomerByUsername(String username);
    @Query(nativeQuery = true, value = "select id, address, birthday, card_id, email, full_name, gender, is_delete, phone_number, username from customer where username = ?")
    Customer findCustomerByAccount(String account );

    @Query(value = "select * from customer where username = ?1",nativeQuery = true)
    Optional<Customer> findByIdForByUpdate(String username);



}