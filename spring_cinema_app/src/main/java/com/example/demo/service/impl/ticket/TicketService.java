package com.example.demo.service.impl.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public Page<Ticket> findAllTicketByCustomer(Customer customer, Pageable pageable) {
        return iTicketRepository.findTicketByCustomer(customer.getId(), pageable);
    }
}
