package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    private List<Ticket> ticketCheckList = new ArrayList<>();

    /**
     * Lấy ra tất cả ticket trong db...
     * @return List<Ticket>
     */
    @GetMapping("/ticket/list")
    public ResponseEntity<List<Ticket>> findAllTicket() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    /**
     * Tìm kiếm ticket theo id
     * @return Ticket
     */
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);}
    /**
     * @param
     * @return List<Ticket>
     * @content get all ticket of showtime and room now
     * @author PhatVN
     */
    @GetMapping("/user/ticket/list-ticket-by-rom-showtime/{idRoom}/{idShowTime}")
    public ResponseEntity<List<Ticket>> getAllTicketByShowTimeAndIdRoom(@PathVariable("idRoom")Integer idRoom, @PathVariable("idShowTime")Integer idShowTime){
        List<Ticket> ticketList = ticketService.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
        if (ticketList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/ticket/addTicketCheckList/{ticketId}")
    public ResponseEntity<Void> addTicketCheckList(@PathVariable String ticketId) {
        for (Ticket ticket : ticketCheckList) {
            if (Objects.equals(ticketId, ticket.getId())) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }
        Ticket ticket = ticketService.findById(ticketId);
        ticketCheckList.add(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ticket/clearTicketCheckList")
    public void clearTicketCheckList() {
        ticketCheckList.clear();
    }
}