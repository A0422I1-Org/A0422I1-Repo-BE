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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{id}")
    public Customer findCustomerById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping("/user/findByUsername/{username}")
    public ResponseEntity<Customer> findCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(customerService.findByUsername(username), HttpStatus.OK);
    }

    /**
     * Mô phỏng dữ liệu cứng
     * Lấy ra những vé người dùng đã chọn
     * TanHP
     * @return List<Ticket>
     */
    @GetMapping("/user/ticket-choosed")
    public ResponseEntity<List<Ticket>> findTicketsChoosed() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticketService.findById("1"));
        ticketList.add(ticketService.findById("2"));
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    /**
     * @param ticket
     * Cập nhật thông tin vé khi xác nhận đặt vé. Thay đổi trạng thái vé và thêm customer_id vào vé
     * TanHP
     */
    @PostMapping("/user/confirm-booking-ticket")
    public ResponseEntity<Void> confirmBookingTicket(@RequestBody Ticket ticket, Principal principal) {
        Customer customer = customerService.findByUsername(principal.getName());
        ticket.setStatus(true);
        ticket.setCustomer(customer);
        Date date = new Date();
        ticket.setBookDateTime(date);
        ticketService.createOrUpdate(ticket);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(customer.getEmail());
        message.setSubject("ĐẶT VÉ THÀNH CÔNG");
        message.setText("Xác nhận đặt vé thành công !!!" +
                "\n-------- Thông tin vé ----------" +
                "\nMã vé: " + ticket.getId() +
                "\nRạp: " + ticket.getChairRoom().getRoom().getName() +
                "\nMàn hình : " + ticket.getChairRoom().getRoom().getScreen() +
                "\nGhế : " + ticket.getChairRoom().getChair().getName() +
                "\nGiá vé : " + ticket.getPrice() +
                "\n-------- Thông tin khách hàng ----------" +
                "\nHọ tên : " + customer.getFullName() +
                "\nEmail : " + customer.getEmail() +
                "\nCMND : " + customer.getCardId() +
                "\nSố điện thoại: " + customer.getPhoneNumber());

        javaMailSender.send(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @param page
     * @return Ticket List
     * @Method : Get all ticket by customer
     * @Author : TriLHH
     */
    @GetMapping("/user/ticket/{page}")
    public ResponseEntity<Page<Ticket>> getAllTicketByCustomer(@PathVariable int page, Principal principal) {
        Account account = accountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = customerService.findCustomerByAccount(account);
        Page<Ticket> ticketList = ticketService.findAllTicketByCustomer(customer, PageRequest.of(page, 5));
        if (ticketList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/admin/customer-management")
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
        System.out.println("test - list customer");
        Sort sortable = Sort.by("id").ascending();
        if (sort.equals("asc")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("desc")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return new ResponseEntity<>(customerService.searchCustomerByName(search, pageable), HttpStatus.OK);
    }

    @GetMapping("/admin/update/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        /**
         * Method: get customer by id
         * Author: DanhHC
         * Params: customer id
         * Return: customer with corresponding id
         */
        System.out.println("test - id customer");
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    @PutMapping("/admin/update")
    public void updateCustomer(@RequestBody Customer customer) {
        /**
         * Method: edit customer
         * Author: DanhHC
         * Params: customer
         * Return: void
         */
        customerService.saveCustomer(customer);
        String passInput = customer.getAccount().getPassword();
        String passEncode = passwordEncoder.encode(passInput);
        customer.getAccount().setPassword(passEncode);
        accountService.updatePassword(customer);
    }
}

