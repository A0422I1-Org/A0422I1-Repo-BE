package com.example.demo.repository.ticket;

import com.example.demo.model.movie.MovieType;
import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    @Query(nativeQuery = true, value =
            "SELECT start_time, MAX(sold_out) AS max_sold_out, MAX(sold_out) * 50000 AS totalRevenue " +
                    "FROM show_time " +
                    "GROUP BY start_time " +
                    "ORDER BY max_sold_out ASC;")
    List<?> statisticShowtime();

}
