package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("customer")
public class CustomerManagementController {
    @Autowired
    private ITicketService iTicketService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer-ticket/{customerId}")
    public ResponseEntity<List<Ticket>> getAllTicketByCustomer(@PathVariable String customerId) {
        Customer customer = iCustomerService.findById(customerId);
        List<Ticket> ticketList = iTicketService.findAllTicketByCustomer(customer);
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

}
