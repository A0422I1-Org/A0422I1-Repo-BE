package com.codegym.demo.service.ticket;


import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.ticket.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAllTicketByCustomer(Customer customer);
}
