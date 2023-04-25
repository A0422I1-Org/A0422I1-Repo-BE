package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Modifying
    @Query(value =
            "SELECT m.id, m.description, m.image,m.is_delete,m.language,m.name,m.rating,m.start_day,m.status,m.time_amount,m.trailer " +
                    "FROM Movie m " +
                    "join show_time st on st.movie_id = m.id " +
                    "where st.date >= CURRENT_TIME  group by m.id ", nativeQuery = true)
    List<Movie> findMoviesByStartDate(LocalDate threeDaysLater);
}
