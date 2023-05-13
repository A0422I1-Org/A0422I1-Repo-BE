package com.codegym.demo.repository.ticket;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITicketRepository  extends JpaRepository<Ticket,Integer> {
    List<Ticket> findTicketByCustomer(Customer customer);
}
