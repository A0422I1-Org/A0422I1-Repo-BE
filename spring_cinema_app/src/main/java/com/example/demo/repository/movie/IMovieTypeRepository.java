package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import com.example.demo.model.movie.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {

    @Query(nativeQuery = true, value = "SELECT movie_type.name, COUNT(*) as totalTicket, COUNT(*) * 50000 as totalRevenue " +
            "FROM movie_type " +
            "JOIN movie_and_type ON movie_type.id = movie_and_type.movie_type_id " +
            "JOIN movie ON movie_and_type.movie_id = movie.id " +
            "WHERE movie.is_delete = 0 " +
            "GROUP BY movie_type.name " +
            "ORDER BY totalTicket DESC;")
    List<?> statisticCategoryMovie();

}
