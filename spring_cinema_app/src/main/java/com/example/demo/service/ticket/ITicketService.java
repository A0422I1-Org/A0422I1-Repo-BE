package com.example.demo.service.ticket;

import com.example.demo.model.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    Iterable<Ticket> searchTicket(String name);
    Optional<Ticket> detail(String id);
    Boolean bookingConfirmation(String id);
    Boolean deleteTicket(String id);


}
