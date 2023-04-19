package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(nativeQuery = true, value = "select * FROM ticket WHERE customer_id = ?  and is_delete = false")
    Page<Ticket> findTicketByCustomer(String customer, Pageable pageable);
}
