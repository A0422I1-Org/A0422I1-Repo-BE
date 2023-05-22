package com.example.demo.service.customer;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    /**
     * Pham Trung Hieu
     * @param id
     * @param fullName
     * @param email
     * @param username
     */
    void saveCustomerLoginWithGoogle(String id, String fullName, String email, String username);

    Page<CustomerDTO> getListCustomerDTODesc(Pageable pageable);

    Page<CustomerDTO> getListCustomerDTOAcs(Pageable pageable);

    Page<CustomerDTO> searchCustomerStatisticListByNameDesc(String nameCustomer, Pageable pageable);

    Page<CustomerDTO> searchCustomerStatisticListByNameAcs(String nameCustomer , Pageable pageable);

    List<CustomerDTO> convertCustomerToDTO(List<Customer> customers);

    Page<CustomerDTO> convertListToPage(List<CustomerDTO> customerDTOs , Pageable pageable);

    int getRankCustomer(String id);
    Customer findCustomerById(String id);
    Page<Customer> searchCustomerByName(String name, Pageable pageable);
    void saveCustomer(Customer customer);
    void save(Customer customer);

    /**
     * Pham Trung Hieu
     * @param email
     * @return email
     */
    String existsByEmail(String email);
    Customer findById(String customerId);
    Customer findByUsername(String username);
    Customer getCustomerByAccount(String username);
    Customer findCustomerByAccount(Account account );

    /**
     * Nghia TDD
     */
    void updateCustomer(Customer customer);
    /**
     * Nghia TDD
     */
    Optional<Customer> findByIdForByUpdate(String id);


}