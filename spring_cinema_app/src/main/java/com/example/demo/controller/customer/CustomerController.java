package com.example.demo.controller.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<Customer> findCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(customerService.findByUsername(username), HttpStatus.OK);
    }

    /**
     * @param ticket
     * Cập nhật thông tin vé khi xác nhận đặt vé. Thay đổi trạng thái vé và thêm customer_id vào vé
     * TanHP
     */
    @PostMapping("/confirm-booking-ticket")
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

}
