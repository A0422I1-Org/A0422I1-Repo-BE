package com.example.demo.controller.ticket;


import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinema/ticket")
public class TicketController {
    @Autowired
    ITicketService ticketService;
    @GetMapping("/list-ticket")
    public List<Ticket> getAllTicket(){
        return ticketService.findAllTicket();
    }
}
