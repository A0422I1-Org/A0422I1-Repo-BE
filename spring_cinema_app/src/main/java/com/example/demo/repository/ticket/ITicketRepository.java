package com.example.demo.repository.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTicketByCustomer(Customer customer);
    @Modifying
    @Query(value =
            "SELECT t.id,t.book_date_time,t.is_delete,t.price,t.status,t.chair_room_id,t.customer_id,t.showtime_id" +
                    " FROM ticket t " +
                    "JOIN chair_room cr ON t.chair_room_id = cr.id " +
                    "JOIN room r ON cr.room_id = r.id " +
                    "WHERE r.id = :idRoom AND t.showtime_id = :idShowTime AND t.status = 1 AND r.is_delete = 0 AND cr.is_delete = 0 AND t.is_delete = 0",
            nativeQuery = true)
    List<Ticket> findTicketAvailable(@Param("idRoom") Integer idRoom, @Param("idShowTime") Integer idShowTime);

    @Modifying
    @Query(value =
            "SELECT t.id,t.book_date_time,t.is_delete,t.price,t.status,t.chair_room_id,t.customer_id,t.showtime_id" +
                    " FROM ticket t " +
                    "JOIN chair_room cr ON t.chair_room_id = cr.id " +
                    "WHERE cr.room_id = :idRoom AND t.showtime_id = :idShowTime   AND cr.is_delete = 0 AND t.is_delete = 0",
            nativeQuery = true)
    List<Ticket> findTicketByShowTimeAndIdRoom(@Param("idRoom") Integer idRoom, @Param("idShowTime") Integer idShowTime);
}
