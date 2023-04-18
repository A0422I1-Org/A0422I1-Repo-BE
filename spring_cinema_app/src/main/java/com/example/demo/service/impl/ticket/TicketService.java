package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService  implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;
    @Override
    public Iterable<Ticket> searchTicket(String name) {
        return iTicketRepository.searchTicket(name);
    }

    @Override
    public Optional<Ticket> detail(String id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public Boolean bookingConfirmation(String id) {
        return iTicketRepository.bookingConfirmation(id);
    }

    @Override
    public Boolean deleteTicket(String id) {
        return iTicketRepository.deleteTicket(id);
    }
}
