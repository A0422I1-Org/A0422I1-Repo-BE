package com.example.demo.repository.ticket;

import com.example.demo.model.movie.MovieType;
import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    @Query(nativeQuery = true, value = "SELECT show_time.start_time, DATE(ticket.book_datetime) AS sale_date, COUNT(*) AS sold_tickets, COUNT(*) * 50000 AS total_revenue " +
            "FROM ticket " +
            "INNER JOIN show_time ON ticket.showtime_id = show_time.id " +
            "WHERE ticket.status = 1 " +
            "GROUP BY show_time.start_time, sale_date " +
            "ORDER BY total_revenue DESC;")
    List<Map<String, Object>> statisticShowtime();

}
