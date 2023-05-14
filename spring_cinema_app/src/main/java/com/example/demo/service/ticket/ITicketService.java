package com.example.demo.service.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    Page<Ticket> searchTicket(String name, Pageable pageable);
    Optional<Ticket> detail(String id);
    Boolean bookingConfirmation(String id);
    Boolean deleteTicket(String id);
    List<Ticket> findAllTicketByCustomer(Customer customer);
}
