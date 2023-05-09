package com.example.demo.repository.ticket;


import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository

public interface ITicketRepository  extends JpaRepository<Ticket,Integer> {

    @Query(nativeQuery = true , value = "select id, book_datetime, is_delete, price, status, chair_room_id, customer_id, showtime_id from ticket where customer_id = ?1 and is_delete = false ;")
    List<Ticket> findTicketByCustomer(String  customer);


    @Query(value = "select t.id,t.price,t.book_date_time,t.status,t.is_delete,t.customer_id,t.showtime_id,t.chair_room_id from ticket t" +
            " join customer c on t.customer_id = c.id join show_time s on t.showtime_id = s.id join chair_room r on t.chair_room_id =r.id " +
            "where t.status = 1 and t.is_delete = 0 and (t.id like concat('%',:name,'%') or t.customer_id like co" +
            "" +
            "ncat('%',:name,'%') or c.card_id like concat('%',:name,'%') or c.phone_number like concat('%',:name,'%'))", nativeQuery = true, countQuery = "select count(*) from(select t.id,t.price,t.book_date_time,t.status,t.is_delete,t.customer_id,t.showtime_id,t.chair_room_id from ticket t join customer c on t.customer_id = c.id join show_time s on t.showtime_id = s.id join chair_room r on t.chair_room_id =r.id where t.status = 1 and t.is_delete=0 and (t.id like concat('%',:name,'%') or t.customer_id like concat('%',:name,'%')or c.card_id like concat('%',:name,'%') or c.phone_number like concat('%',:name,'%'))) ticket")
    Page<Ticket> searchTicket(@Param("name") String name, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update ticket  set is_delete = 1 where id = :id and customer_id is not null", nativeQuery = true)
    int bookingConfirmation(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "delete from ticket t where t.id = :id and customer_id is not null", nativeQuery = true)
    int deleteTicket(@Param("id") String id);

    Optional<Ticket> findById(String id);
}
