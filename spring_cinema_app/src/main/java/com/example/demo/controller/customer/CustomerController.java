package com.example.demo.controller.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private ITicketService iTicketService;

    @Autowired
    private ICustomerService iCustomerService;


    /**
     * @param page
     * @return Ticket List
     * @Method : Get all ticket by customer
     * @Author : TriLHH
     */
    @GetMapping("/customer-ticket/{page}")
    public ResponseEntity<Page<Ticket>> getAllTicketByCustomer(@PathVariable int page) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Page<Ticket> ticketList = iTicketService.findAllTicketByCustomer(customer, PageRequest.of(page, 5));
        if (ticketList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

}
