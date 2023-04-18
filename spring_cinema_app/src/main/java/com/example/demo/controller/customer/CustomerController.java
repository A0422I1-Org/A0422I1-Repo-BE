package com.example.demo.controller.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-management")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomerList(@PageableDefault(value = 5) Pageable pageable) {
        /**
         * Method: show customer list
         * Author: DanhHC
         * Return: customer list
         */
        return new ResponseEntity<>(customerService.getAllCustomer(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        /**
         * Method: get customer by id
         * Author: DanhHC
         * Params: customer id
         * Return: customer with corresponding id
         */
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK) ;
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<Customer>> searchCustomerByName(@PathVariable(required = false) String name, @PageableDefault(value = 5) Pageable pageable) {
        /**
         * Method: search customer by name
         * Author: DanhHC
         * Params: search input
         * Return: list of customers with names contain search input
         */
        return new ResponseEntity<>(customerService.searchCustomerByName(name, pageable), HttpStatus.OK) ;
    }

    @PutMapping("update")
    public void updateCustomer(Customer customer) {
        /**
         * Method: edit customer
         * Author: DanhHC
         * Params: customer
         * Return: void
         */
        customerService.saveCustomer(customer);
    }
}
