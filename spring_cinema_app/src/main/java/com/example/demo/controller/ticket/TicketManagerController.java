package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin
public class TicketManagerController {
    @Autowired
    private ITicketService iTicketService;
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Ticket>> searchTicket(@PathVariable String name){
        return new ResponseEntity<>(iTicketService.searchTicket(name), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Ticket>> detailTicket(@PathVariable String id){
            Optional<Ticket> ticket = iTicketService.detail(id);
            if(!ticket.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    @GetMapping("/bookingConfirmation/{id}")
    public ResponseEntity<Boolean> bookingConfirmation(@PathVariable String id){
        return new ResponseEntity<>(iTicketService.bookingConfirmation(id),HttpStatus.OK);
    }
    @GetMapping("/deleteTicket/{id}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable String id){
       return new ResponseEntity<>( iTicketService.deleteTicket(id),HttpStatus.OK);
    }

}
