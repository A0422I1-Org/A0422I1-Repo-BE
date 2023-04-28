package com.example.demo.controller.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer-management")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
    private ICustomerService customerService;
    private IAccountService accountService;

    @Autowired
    public CustomerController(ICustomerService customerService, IAccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Customer>> getCustomerList(@RequestParam(name = "search", required = false, defaultValue = "") String search,
                                                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                          @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                                          @RequestParam(name = "sort", required = false, defaultValue = "asc") String sort) {
        /**
         * Method: show customer list, show search result, choose page
         * Author: DanhHC
         * Params: search input, page, size, sort
         * Return: customer list
         */
        Sort sortable = null;
        if (sort.equals("asc")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return new ResponseEntity<>(customerService.searchCustomerByName(search, pageable), HttpStatus.OK);
    }

    @GetMapping("update/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        /**
         * Method: get customer by id
         * Author: DanhHC
         * Params: customer id
         * Return: customer with corresponding id
         */
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @PutMapping("update")
    public void updateCustomer(@RequestBody Customer customer) {
        /**
         * Method: edit customer
         * Author: DanhHC
         * Params: customer
         * Return: void
         */
        try {
            customerService.saveCustomer(customer);
            accountService.updatePassword(customer);
        } catch (Error error) {
            System.out.println(error.getMessage());
        }
    }
}
