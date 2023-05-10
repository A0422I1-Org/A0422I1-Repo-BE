package com.example.demo.service.ticket;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import java.util.List;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();
    Ticket findById(String id);
    void createOrUpdate(Ticket ticket);
    void delete(String id);
    List<Ticket> findAllTicketByCustomer(Customer customer);
}
