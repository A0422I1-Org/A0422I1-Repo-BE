package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketManagerController {
    @Autowired
    private ITicketService iTicketService;
    @GetMapping("")
    public ResponseEntity<Page<Ticket>>searchAndFindAll(@RequestParam(value = "nameSearch" ,defaultValue = "")String name,
                                                        @PageableDefault(value = 2,sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Ticket> tickets=iTicketService.searchTicket(name,pageable);
        if(tickets.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }
//    @GetMapping("/search/{name}")
//    public ResponseEntity<Iterable<Ticket>> searchTicket(@PathVariable String name){
//        return new ResponseEntity<>(iTicketService.searchTicket(name), HttpStatus.OK);
//    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Ticket>> detailTicket(@PathVariable String id){
            Optional<Ticket> ticket = iTicketService.detail(id);
            if(!ticket.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
    @PutMapping("/bookingConfirmation/{id}")
    public ResponseEntity<Boolean> bookingConfirmation(@PathVariable String id){
        return new ResponseEntity<>(iTicketService.bookingConfirmation(id),HttpStatus.OK);
    }
    @DeleteMapping("/deleteTicket/{id}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable String id){
       return new ResponseEntity<>( iTicketService.deleteTicket(id),HttpStatus.OK);
    }

}
