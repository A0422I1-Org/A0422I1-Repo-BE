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

@Repository
@Transactional
public interface IShowTimeRepository extends JpaRepository<ShowTime, Integer> {

    /**
     * @author PhatVN
     */
    @Modifying
    @Query(value =
            "SELECT st.id, st.date, st.end_time as endTime, st.sold_out as soldOut, st.start_time as startTime, st.is_delete as `delete`, st.movie_id as movieId " +
                    "FROM show_time st " +
                    "WHERE st.movie_id = :id AND st.date >= CURDATE() AND st.is_delete = 0 " +
                    "AND (st.date > CURDATE() OR (st.start_time > TIME(NOW() + INTERVAL 30 MINUTE))) " +
                    "ORDER BY st.date ASC, st.start_time ASC"
            , nativeQuery = true)
    List<ShowTimeBookingDTO> findShowTimeByMovieId(@Param("id") int id);


    /**
     * @author PhatVN
     */
    @Query(value =
            "SELECT st.id, st.date, st.end_time, st.sold_out, st.start_time, st.is_delete, st.movie_id " +
                    "FROM show_time st " +
                    "JOIN movie m ON m.id = st.movie_id " +
                    "WHERE st.id = :id"
            , nativeQuery = true)
    ShowTime findShowTimeById(@Param("id") Integer id);
}