package com.example.demo.service.impl.customer;


import com.example.demo.model.customer.Customer;
import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public int getRankCustomer(String id) {
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator.comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .reversed());
        for (int i = 0; i < customerDTOList.size(); i++) {
            if (customerDTOList.get(i).getId().equals(id)) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override
    public Page<CustomerDTO> getListCustomerDTODesc(Pageable pageable) {
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator.comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .reversed());
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    @Override
    public Page<CustomerDTO> getListCustomerDTOAcs(Pageable pageable) {
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator.comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                );
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameDesc(String name, Pageable pageable) {
        List<Customer> customerList = iCustomerRepository.findCustomerByFullNameContaining(name);
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator.comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
                .reversed());
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    @Override
    public Page<CustomerDTO> searchCustomerStatisticListByNameAcs(String name, Pageable pageable) {
        List<Customer> customerList = iCustomerRepository.findCustomerByFullNameContaining(name);
        List<CustomerDTO> customerDTOList = convertCustomerToDTO(customerList);
        customerDTOList.sort(Comparator.comparing(CustomerDTO::getTicket)
                .thenComparing(CustomerDTO::getPoint)
                .thenComparing(CustomerDTO::getMoney)
               );
        Page<CustomerDTO> customerDTOPage = convertListToPage(customerDTOList, pageable);
        return customerDTOPage;
    }

    @Override
    public List<CustomerDTO> convertCustomerToDTO(List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO customerDTO = new CustomerDTO(customers.get(i));
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public Page<CustomerDTO> convertListToPage(List<CustomerDTO> customerDTOs, Pageable pageable) {
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), customerDTOs.size());
        final Page<CustomerDTO> page = new PageImpl<>(customerDTOs.subList(start, end), pageable, customerDTOs.size());
        return page;
    }

}
