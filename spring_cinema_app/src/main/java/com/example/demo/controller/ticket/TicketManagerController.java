package com.example.demo.controller.ticket;

import com.example.demo.dto.TicketViewDTO;
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

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class TicketManagerController {
    @Autowired
    private ITicketService iTicketService;

    /**
     * @param
     * @return Page<Ticket>
     * @content get all Ticket
     * @author DuyetPT
     */
        @GetMapping("")
    public ResponseEntity<Page<Ticket>>searchAndFindAll(@RequestParam(value = "nameSearch" ,defaultValue = "")String name,
                                                               @PageableDefault(value = 5,sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Ticket> tickets=iTicketService.searchTicket(name,pageable);
        if(tickets.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }
    /**
     * @param id of ticket
     * @return Optional<TicketViewDTO>
     * @content get ticket by id
     * @author DuyetPT
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<TicketViewDTO>> detailTicket(@PathVariable String id){
            Optional<TicketViewDTO> ticket = iTicketService.detail(id).map(TicketViewDTO::new);
            if(!ticket.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    /**
     * @param id of ticket
     * @return Boolean
     * @content update ticket by id
     * @author DuyetPT
     */
    @PutMapping("/bookingConfirmation/{id}")
    public ResponseEntity<Boolean> bookingConfirmation(@PathVariable String id){
        return new ResponseEntity<>(iTicketService.bookingConfirmation(id),HttpStatus.OK);
    }

    /**
     * @param id of ticket
     * @return Boolean
     * @content delete ticket by id
     * @author DuyetPT
     */
    @DeleteMapping("/deleteTicket/{id}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable String id){
       return new ResponseEntity<>( iTicketService.deleteTicket(id),HttpStatus.OK);
    }

}
