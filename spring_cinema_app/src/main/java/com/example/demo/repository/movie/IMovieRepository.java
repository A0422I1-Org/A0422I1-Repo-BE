package com.example.demo.repository.movie;

import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    /**
     * @param
     * @return List<MovieBookingDTO>
     * @content find Movies By Start Date
     * @author PhatVN
     */
    @Modifying
    @Query(value =
            "SELECT m.id, m.description, m.image, m.is_delete as isDelete , m.language, m.name, m.rating, m.start_day as startDay, m.status, m.time_amount as timeAmount, m.trailer " +
                    "FROM Movie as m " +
                    "JOIN show_time as st ON st.movie_id = m.id " +
                    "WHERE st.date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 2 DAY) " +
                    "AND (st.date > CURDATE() OR (st.start_time > TIME(NOW())))" +
                    "GROUP BY m.id", nativeQuery = true)
    List<MovieBookingDTO> findMoviesByStartDate();

}
