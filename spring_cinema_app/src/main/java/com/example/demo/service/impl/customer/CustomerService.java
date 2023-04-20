package com.example.demo.service.impl.customer;


import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomerByAccount(Account account) {
        return null;
    }

    @Override
    public Customer findById(String customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
    }


    public List<CustomerDTO> getListCustomerDTO() {
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
       for (int i = 0 ; i<customerList.size() ; i++){
           CustomerDTO customerDTO = new CustomerDTO(customerList.get(i));
           customerDTOList.add(customerDTO);
       }
       customerDTOList.sort((o1, o2) -> o2.getTicket().compareTo(o1.getTicket()));
       return customerDTOList;
    }

    public List<CustomerDTO> getListCustomerDTOAcs() {
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (int i = 0 ; i<customerList.size() ; i++){
            CustomerDTO customerDTO = new CustomerDTO(customerList.get(i));
            customerDTOList.add(customerDTO);
        }
        customerDTOList.sort((o1, o2) -> o1.getTicket().compareTo(o2.getTicket()));
        return customerDTOList;
    }

    public List<CustomerDTO> searchCustomerStatisticListByName(String name) {
        List<Customer> customerList = iCustomerRepository.findCustomerByFullNameContaining(name);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (int i = 0 ; i<customerList.size() ; i++){
            CustomerDTO customerDTO = new CustomerDTO(customerList.get(i));
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

}
