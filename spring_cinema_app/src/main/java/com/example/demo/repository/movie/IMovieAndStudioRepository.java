package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieAndStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieAndStudioRepository extends JpaRepository<MovieAndStudio, Integer> {

    @Query(value = "select * from movie_and_studio where movie_id = ?1", nativeQuery = true)
    List<MovieAndStudio> findAllMovieAndStudioByMovieId(Integer id);
}
