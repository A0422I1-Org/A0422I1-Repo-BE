package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable String id) {
        return customerService.findById(id);
    }

}
