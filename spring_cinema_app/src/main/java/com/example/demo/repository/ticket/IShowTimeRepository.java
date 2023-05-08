package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    @Query(nativeQuery = true, value = "SELECT show_time.start_time as startTime, DATE_FORMAT(ticket.book_date_time, '%d/%m/%Y') AS saleDate, COUNT(*) AS soldTickets, COUNT(*) * price AS totalRevenue " +
            "FROM ticket " +
            "INNER JOIN show_time ON ticket.showtime_id = show_time.id " +
            "WHERE ticket.status = 1 " +
            "GROUP BY show_time.start_time, saleDate " +
            "ORDER BY totalRevenue DESC;")
    List<Map<String, Object>> statisticShowtime();

}
