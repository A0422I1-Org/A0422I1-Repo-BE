package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import com.example.demo.model.movie.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {
    @Query(nativeQuery = true, value = "SELECT mt.name AS movie_type, COUNT(t.id) AS total_tickets_sold, DATE(t.book_datetime) AS sold_date, COUNT(t.id) * 50000 AS total_revenue " +
            "FROM movie_type mt " +
            "INNER JOIN movie_and_type mat ON mt.id = mat.movie_type_id " +
            "INNER JOIN movie m ON mat.movie_id = m.id " +
            "INNER JOIN show_time st ON m.id = st.movie_id " +
            "INNER JOIN ticket t ON st.id = t.showtime_id " +
            "WHERE t.status = 1 AND t.is_delete = 0 AND m.is_delete = 0 AND st.is_delete = 0 " +
            "GROUP BY mt.name, DATE(t.book_datetime) " +
            "ORDER BY total_revenue DESC;")
    List<Map<String, Object>> statisticCategoryMovie();}
