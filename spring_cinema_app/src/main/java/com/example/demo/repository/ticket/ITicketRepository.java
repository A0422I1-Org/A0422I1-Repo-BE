package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository  extends JpaRepository<Ticket, String> {
    @Query(value="select * from ticket", nativeQuery=true)
    List<Ticket> findAllTicket();
    @Query(value="select * from ticket where id = ?", nativeQuery=true)
    Ticket findTicketById(String id);
}
