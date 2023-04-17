package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService  implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findById(String id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public void createOrUpdate(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(String id) {
        ticketRepository.deleteById(id);
    }
}
