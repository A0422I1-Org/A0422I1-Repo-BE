package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {
    /**
     * @param
     * @return List<Map<String, Object>>
     * @content statistic movie type
     * @author NghiaDC
     */
    @Query(nativeQuery = true, value = "SELECT mt.name AS movieType, COUNT(t.id) AS totalTicketsSold, DATE_FORMAT(t.book_date_time, '%d/%m/%Y') AS soldDate, COUNT(t.id) * price AS totalRevenue " +
            "FROM movie_type mt " +
            "INNER JOIN movie_and_type mat ON mt.id = mat.movie_type_id " +
            "INNER JOIN movie m ON mat.movie_id = m.id " +
            "INNER JOIN show_time st ON m.id = st.movie_id " +
            "INNER JOIN ticket t ON st.id = t.showtime_id " +
            "WHERE t.status = 1 AND t.is_delete = 0 AND m.is_delete = 0 AND st.is_delete = 0 " +
            "GROUP BY mt.name, DATE_FORMAT(t.book_date_time, '%d/%m/%Y') " +
            "ORDER BY totalRevenue DESC;")
    List<Map<String, Object>> statisticCategoryMovie();
}
