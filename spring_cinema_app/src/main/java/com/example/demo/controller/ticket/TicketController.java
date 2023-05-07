package com.example.demo.controller.ticket;


import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    ITicketService ticketService;
    /**
     * @param
     * @return List<Ticket>
     * @content get all ticket of showtime and room now
     * @author PhatVN
     */
    @GetMapping("/list-ticket-by-rom-showtime/{idRoom}/{idShowTime}")
    public ResponseEntity<List<Ticket>> getAllTicketByShowTimeAndIdRoom(@PathVariable("idRoom")Integer idRoom, @PathVariable("idShowTime")Integer idShowTime){
        List<Ticket> ticketList = ticketService.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
        if (ticketList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }
}
