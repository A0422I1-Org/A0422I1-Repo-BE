package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ICustomerService {

    Page<CustomerDTO> getListCustomerDTODesc(Pageable pageable);

    Page<CustomerDTO> getListCustomerDTOAcs(Pageable pageable);

    Page<CustomerDTO> searchCustomerStatisticListByNameDesc(String nameCustomer, Pageable pageable);

    Page<CustomerDTO> searchCustomerStatisticListByNameAcs(String nameCustomer , Pageable pageable);

    List<CustomerDTO> convertCustomerToDTO(List<Customer> customers);

    Page<CustomerDTO> convertListToPage(List<CustomerDTO> customerDTOs , Pageable pageable);

    int getRankCustomer(String id);

}
