package com.example.demo.controller;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    /**
     * Lấy ra tất cả ticket trong db...
     * @return List<Ticket>
     */
    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> findAllTicket() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    /**
     * Tìm kiếm ticket theo id
     * @return Ticket
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
    }
}
