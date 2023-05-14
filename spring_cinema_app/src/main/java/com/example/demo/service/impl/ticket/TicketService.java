package com.example.demo.service.impl.ticket;
import com.example.demo.model.customer.Customer;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService  implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAllTicket();
    }

    @Override
    public Ticket findById(String id) {
        return ticketRepository.findTicketById(id);
    }

    @Override
    public void createOrUpdate(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(String id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findAllTicketByCustomer(Customer customer) {
        return ticketRepository.findTicketByCustomer(customer);
    }

    @Override
    public Page<Ticket> findAllTicketByCustomer(Customer customer, Pageable pageable) {
        return ticketRepository.findTicketByCustomer(customer.getId(), pageable);
    }

    /**
     * @param
     * @return List<Ticket>
     * @content find all ticket of showtime and room now
     * @author PhatVN
     */
    @Override
    public List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom, Integer idShowTime) {
        return ticketRepository.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
    }

}