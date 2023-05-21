package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieDirectorRepository extends JpaRepository<MovieDirector, Integer> {
    @Query(value = "select * from movie_director where movie_id = ?1", nativeQuery = true)
    List<MovieDirector> findAllMovieDirectorByMovieId(Integer id);
}
