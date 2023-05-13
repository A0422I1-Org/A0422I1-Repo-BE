package com.codegym.demo.service.impl.ticket;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.ticket.Ticket;
import com.codegym.demo.repository.ticket.ITicketRepository;
import com.codegym.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public List<Ticket> findAllTicketByCustomer(Customer customer) {
        return iTicketRepository.findTicketByCustomer(customer);
    }
}
