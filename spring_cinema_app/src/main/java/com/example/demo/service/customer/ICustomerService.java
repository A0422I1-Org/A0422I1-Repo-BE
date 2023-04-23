package com.example.demo.service.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.dto.StatisticDTO.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    Customer findCustomerByAccount(Account account);

    Customer findById(String customerId);

    List<CustomerDTO> getListCustomerDTO();

    List<CustomerDTO> getListCustomerDTOAcs();

    List<CustomerDTO> searchCustomerStatisticListByNameDesc(String name);

    List<CustomerDTO> searchCustomerStatisticListByNameAcs(String name);

}
