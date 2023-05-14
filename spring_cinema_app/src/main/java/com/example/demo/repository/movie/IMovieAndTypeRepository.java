package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieAndType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieAndTypeRepository extends JpaRepository<MovieAndType, Integer> {

    @Query(value = "select * from movie_and_type where movie_id = ?1", nativeQuery = true)
    List<MovieAndType> findAllMovieAndTypeByMovieId(Integer id);
}
