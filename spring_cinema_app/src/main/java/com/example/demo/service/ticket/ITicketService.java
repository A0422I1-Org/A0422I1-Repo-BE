package com.example.demo.service.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ITicketService {
    Page<Ticket> findAllTicketByCustomer(Customer customer, Pageable pageable);
}
