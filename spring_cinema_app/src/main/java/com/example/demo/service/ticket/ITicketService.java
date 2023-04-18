package com.example.demo.service.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket>findAllTicketByCustomer(Customer customer);
}
