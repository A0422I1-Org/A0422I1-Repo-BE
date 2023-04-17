package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository  extends JpaRepository<Ticket, String> {
}
