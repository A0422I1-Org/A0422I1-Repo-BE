package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    ITicketService ticketService;
    @GetMapping("/list-ticket-by-rom-showtime/{idRoom}/{idShowTime}")
    public List<Ticket> getAllTicketByShowTimeAndIdRoom(@PathVariable("idRoom")Integer idRoom,@PathVariable("idShowTime")Integer idShowTime){
        return ticketService.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
    }
}
