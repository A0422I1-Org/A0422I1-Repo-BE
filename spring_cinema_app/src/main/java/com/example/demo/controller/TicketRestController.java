package com.example.demo.controller;

import com.example.demo.config.MyConstants;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Lấy ra tất cả ticket trong db...
     * @return List<Ticket>
     */
    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> findAllTicket() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    /**
     * Mô phỏng dữ liệu cứng
     * Lấy ra những vé người dùng đã chọn
     * @return List<Ticket>
     */
    @GetMapping("/ticket-choosed")
    public ResponseEntity<List<Ticket>> findTicketsChoosed() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticketService.findById("11"));
        ticketList.add(ticketService.findById("12"));
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    /**
     * Tìm kiếm ticket theo id
     * @return Ticket
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
    }

    /**
     * @param ticket
     * Cập nhật thông tin vé khi xác nhận đặt vé. Thay đổi trạng thái vé và thêm customer_id vào vé
     */
    @PostMapping("/confirm-booking-ticket")
    public void confirmBookingTicket(@RequestBody Ticket ticket) {
        Customer customer = customerService.findById("KH-002");
        ticket.setStatus(true);
        ticket.setCustomer(customer);
        ticketService.createOrUpdate(ticket);
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("ĐẶT VÉ THÀNH CÔNG");
        message.setText("Xác nhận đặt vé thành công !!!" +
                "\n-------- Thông tin vé ----------"+
                "\nMã vé: " + ticket.getId() +
                "\nRạp: " + ticket.getChairRoom().getRoom().getName() +
                "\nMàn hình : " + ticket.getChairRoom().getRoom().getScreen() +
                "\nGhế : " + ticket.getChairRoom().getChair().getName() +
                "\nGiá vé : " + ticket.getPrice() +
                "\n-------- Thông tin khách hàng ----------"+
                "\nHọ tên : " + customer.getFullName() +
                "\nEmail : " + customer.getEmail() +
                "\nEmail : " + customer.getCardId() +
                "\nSố điện thoại: " + customer.getPhoneNumber());

        // Send Message!
        this.mailSender.send(message);
    }
}
