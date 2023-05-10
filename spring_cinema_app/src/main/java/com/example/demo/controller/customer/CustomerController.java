package com.example.demo.controller.customer;

import com.example.demo.dto.CustomerDTO;
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

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private HttpSession session;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private ITicketService iTicketService;

    @GetMapping("/{username}")
    public ResponseEntity<Customer> findCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(this.iCustomerService.findCustomerByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateTaiKhoan(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getFullName(),
                customerDTO.getGender(),
                customerDTO.getBirthday(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddress(),
                customerDTO.getCardId()
        );
        iCustomerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @param page
     * @return Ticket List
     * @Method : Get all ticket by customer
     * @Author : TriLHH
     */
    @GetMapping("/ticket/{page}")
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