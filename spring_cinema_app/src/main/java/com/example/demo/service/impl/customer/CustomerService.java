package com.example.demo.service.impl.customer;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

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
     * Find a rank of customer
     *
     * @param id id of customer wanna get rank
     * @return ranking of customer
     *
     * @Author: DuHC
     */
    @Override
    public int getRankCustomer(String id) {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator
                .comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .thenComparing(CustomerDTO::getFullName)
                .reversed());
        for (int i = 0; i < customerDTOList.size(); i++) {
            if (customerDTOList.get(i).getId().equals(id)) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * Get list customer and Convert to CustomerDTO and sorting decrease by ticket
     *
     * @param pageable page
     * @return a new Page<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<CustomerDTO> getListCustomerDTODesc(Pageable pageable) {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator
                .comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .thenComparing(CustomerDTO::getFullName)
                .reversed());
        System.out.println(customerDTOList.get(0).getFullName());
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    /**
     * Get list customer and Convert to CustomerDTO and sorting increase by ticket
     *
     * @param pageable page
     * @return a new Page<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<CustomerDTO> getListCustomerDTOAcs(Pageable pageable) {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator
                .comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .thenComparing(CustomerDTO::getFullName)
        );
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    /**
     * Search list customer and Convert to CustomerDTO and sorting decrease by ticket
     *
     * @param pageable page
     * @param name     name of customer wanna search
     * @return a new Page<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameDesc(String name, Pageable pageable) {
        List<Customer> customerList = customerRepository.findCustomerByFullNameContaining(name);
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator
                .comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .thenComparing(CustomerDTO::getFullName)
                .reversed());
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    /**
     * Search list customer and Convert to CustomerDTO and sorting increase by ticket
     *
     * @param pageable page
     * @param name     name of customer wanna search
     * @return a new Page<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameAcs(String name, Pageable pageable) {
        List<Customer> customerList = customerRepository.findCustomerByFullNameContaining(name);
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator
                .comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .thenComparing(CustomerDTO::getFullName)
        );
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    /**
     * Convert List<Customer> to List<CustomerDTO>
     *
     * @param customers list customer wanna convert
     * @return a new List<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public List<CustomerDTO> convertCustomerToDTO(List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        if (customers.isEmpty()){
            return customerDTOList;
        }
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO customerDTO = new CustomerDTO(customers.get(i));
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    /**
     * Convert a List<CustomerDTO> to Page<CustomerDTO>
     *
     * @param customerDTOs list customer wanna convert
     * @param pageable     a page have size of page
     * @return a new Page<CustomerDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<CustomerDTO> convertListToPage(List<CustomerDTO> customerDTOs, Pageable pageable) {
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), customerDTOs.size());
        final Page<CustomerDTO> page = new PageImpl<>(customerDTOs.subList(start, end), pageable, customerDTOs.size());
        return page;
    }

    @Override
    public Customer findCustomerById(String id) {
        /**
         * @method: get customer by id
         * @author: DanhHC
         * @params: customer id
         * @return: customer with corresponding id
         */
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Page<Customer> searchCustomerByName(String name, Pageable pageable) {
        /**
         * @method: show customer list, show search result, choose page
         * @author: DanhHC
         * @params: search input, pageable
         * @return: customer list
         */
        return customerRepository.searchCustomerByName(name, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        /**
         * @method: edit customer
         * @author: DanhHC
         * @params: customer
         * @return: void
         */
        customerRepository.updateCustomer(customer.getId(), customer.getFullName(), customer.getBirthday(), customer.getGender(),
                customer.getEmail(), customer.getCardId(), customer.getPhoneNumber(), customer.getAddress());
    }

    /**
     * @author: DanhHC
     */
    public Integer checkDuplicateEmail(String email) {
        return customerRepository.checkDuplicateEmail(email);
    }

    /**
     * @author: DanhHC
     */
    public Integer checkDuplicatePhoneNumber(String phoneNumber) {
        return customerRepository.checkDuplicatePhoneNumber(phoneNumber);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public String existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
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
    public Customer getCustomerByAccount(String username) {
        return customerRepository.getCustomerByAccount(username);
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
        System.out.println(customer.getId()+""+
                customer.getFullName()+""+
                customer.getGender()+""+
                customer.getBirthday()+""+
                customer.getEmail()+""+
                customer.getPhoneNumber()+""+
                customer.getAddress()+""+
                customer.getCardId());
        customerRepository.updateCustomer(customer.getId(), customer.getFullName(),
                customer.getBirthday(), customer.getGender(), customer.getCardId(),
                customer.getEmail(), customer.getPhoneNumber(),customer.getAddress());
    }

    /**
     * Nghia TDD
     */
    @Override
    public Optional<Customer> findByIdForByUpdate(String id) {
        return customerRepository.findByIdForByUpdate(id);
    }
}
