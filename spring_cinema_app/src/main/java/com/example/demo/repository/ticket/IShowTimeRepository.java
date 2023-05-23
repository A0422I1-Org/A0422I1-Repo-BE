package com.example.demo.repository.ticket;

import com.example.demo.dto.ticket.ShowTimeBookingDTO;
import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface IShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    /**
     * @param
     * @return List<ShowTimeBookingDTO>
     * @content find all showtime by  idMovie
     * @author PhatVN
     */
    @Modifying
    @Query(value =
            "SELECT st.id, st.date, st.end_time as endTime, st.sold_out as soldOut, st.start_time as startTime, st.is_delete as `delete`, st.movie_id as movieId " +
                    "FROM show_time st " +
                    "WHERE st.movie_id = :id AND st.date >= CURDATE() AND st.is_delete = 0 " +
                    "AND (st.date > CURDATE() OR (st.start_time > TIME(NOW() + INTERVAL 10 MINUTE))) " +
                    "ORDER BY st.date ASC, st.start_time ASC"
            , nativeQuery = true)
    List<ShowTimeBookingDTO> findShowTimeByMovieId(@Param("id") int id);
    /**
     * @param
     * @return List<ShowTimeBookingDTO>
     * @content find all showtime by  id
     * @author PhatVN
     */

    @Query(value =
            "SELECT st.id, st.date, st.end_time, st.sold_out, st.start_time, st.is_delete, st.movie_id " +
                    "FROM show_time st " +
                    "JOIN movie m ON m.id = st.movie_id " +
                    "WHERE st.id = :id"
            , nativeQuery = true)
    ShowTime findShowTimeById(@Param("id") Integer id);

    /**
     * @param
     * @return List<Map<String, Object>>
     * @content statistic showtime
     * @author NghiaDC
     */
    @Query(nativeQuery = true, value = "SELECT show_time.start_time as startTime, DATE_FORMAT(ticket.book_date_time, '%d/%m/%Y') AS saleDate, COUNT(*) AS soldTickets, COUNT(*) * price AS totalRevenue " +
            "FROM ticket " +
            "INNER JOIN show_time ON ticket.showtime_id = show_time.id " +
            "WHERE ticket.status = 1 OR ticket.status = 2 " +
            "GROUP BY show_time.start_time, saleDate , price " +
            "ORDER BY totalRevenue DESC;")
    List<Map<String, Object>> statisticShowtime();
}

