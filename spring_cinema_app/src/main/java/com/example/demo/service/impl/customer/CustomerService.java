package com.example.demo.service.impl.customer;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

//    private ICustomerRepository iCustomerRepository;
//
//    @Autowired
//    public CustomerService(ICustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    /**
     * Pham Trung Hieu
     * @param id
     * @param fullName
     * @param email
     * @param username
     */
    @Override
    public void saveCustomerLoginWithGoogle(String id, String fullName, String email, String username) {
        customerRepository.saveCustomerLoginWithGoogle(id, fullName, email, username);
    }

    @Override
    public Page<CustomerDTO> getListCustomerDTODesc(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CustomerDTO> getListCustomerDTOAcs(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameDesc(String nameCustomer, Pageable pageable) {
        return null;
    }

    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameAcs(String nameCustomer, Pageable pageable) {
        return null;
    }

    @Override
    public List<CustomerDTO> convertCustomerToDTO(List<Customer> customers) {
        return null;
    }

    @Override
    public Page<CustomerDTO> convertListToPage(List<CustomerDTO> customerDTOs, Pageable pageable) {
        return null;
    }

    @Override
    public int getRankCustomer(String id) {
        return 0;
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Page<Customer> searchCustomerByName(String name, Pageable pageable) {
        return customerRepository.searchCustomerByName(name, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getId(), customer.getFullName(), customer.getBirthday(), customer.getGender(),
                customer.getEmail(), customer.getCardId(), customer.getPhoneNumber(), customer.getAddress());
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Pham Trung Hieu
     * @param email
     * @return exist by email
     */
    @Override
    public String existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    /**
     * Pham Trung Hieu
     * @param username
     * @return Customer by username
     */
    @Override
    public Customer getCustomerByAccount(String username) {
        return customerRepository.getCustomerByAccount(username);
    }

    @Override
    public Customer findById(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public Customer findCustomerByAccount(Account account) {
        return customerRepository.findCustomerByAccount(account.getUsername());
    }

    /**
     * Nghia TDD
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getId(), customer.getFullName(),
                customer.getBirthday(), customer.getGender(), customer.getCardId(),
                customer.getEmail(), customer.getAddress(), customer.getPhoneNumber());
    }

    /**
     * Nghia TDD
     */
    @Override
    public Optional<Customer> findByIdForByUpdate(String id) {
        return customerRepository.findByIdForByUpdate(id);
    }
}