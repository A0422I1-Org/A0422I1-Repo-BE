package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ITicketRepository  extends JpaRepository<Ticket,Integer> {
}
