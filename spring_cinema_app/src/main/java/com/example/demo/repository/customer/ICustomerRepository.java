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
import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String> {
    /**
     * @method: get customer by id
     * @author: DanhHC
     * @params: customer id
     * @return: customer with corresponding id
     */
    @Query(nativeQuery = true, value = "SELECT id, address, birthday, card_id, email, full_name, gender," +
            "is_delete, phone_number, username FROM customer c WHERE id = ?1")
    Customer findCustomerById(String id);

    /**
     * @method: show customer list, show search result, choose page
     * @author: DanhHC
     * @params: search input, page, size, sort
     * @return: customer list
     */
    @Query(nativeQuery = true, value = "SELECT * FROM customer " +
            "WHERE full_name LIKE CONCAT('%',?1,'%') OR phone_number LIKE CONCAT('%',?1,'%') " +
            "OR card_id LIKE CONCAT('%',?1,'%') OR email LIKE CONCAT('%',?1,'%')")
    Page<Customer> searchCustomerByName(String name, Pageable pageable);

    /**
     * @method: edit customer
     * @author: DanhHC
     * @params: customer
     * @return: void
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE customer SET full_name = ?2, birthday = ?3, gender = ?4," +
            "email = ?5, card_id = ?6, phone_number = ?7, address = ?8 WHERE id = ?1")
    void updateCustomer(String id, String fullName, Date birthday, boolean gender, String email,
                        String cardId, String phoneNumber, String address);

    /**
     * @author: DanhHC
     */
    @Query(value = "select count(email) from customer where email =?1", nativeQuery = true)
    Integer checkDuplicateEmail(String email);

    /**
     * @author: DanhHC
     */
    @Query(value = "select count(phone_number) from customer where phone_number =?1", nativeQuery = true)
    Integer checkDuplicatePhoneNumber(String phoneNumber);

    /**
     * Pham Trung Hieu
     * @param email
     * @return email to reset password
     */
    @Query(value = "select email from customer where email =?1", nativeQuery = true)
    String existsByEmail(String email);
    @Query(value = "select * from customer where username = ?", nativeQuery = true)
    Customer findCustomerByUsername(String username);
    Customer getCustomerByAccount(@Param("username")String username);
    @Query(nativeQuery = true, value = "select id, address, birthday, card_id, email, full_name, gender, is_delete, phone_number, username from customer where username = ?")
    Customer findCustomerByAccount(String account );

    @Query(value = "select * from customer where username = ?1",nativeQuery = true)
    Optional<Customer> findByIdForByUpdate(String username);

    /**
     *
     * @param name
     * @return list customer
     *
     * Author : DuHC
     */
    List<Customer> findCustomerByFullNameContaining(String name);
}
