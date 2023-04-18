package com.example.demo.repository.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository  extends JpaRepository<Ticket,Integer> {

    @Query(nativeQuery = true , value = "select id, book_datetime, is_delete, price, status, chair_room_id, customer_id, showtime_id from ticket where customer_id = ?1 and is_delete = false ;")
    List<Ticket> findTicketByCustomer(String  customer);
}
