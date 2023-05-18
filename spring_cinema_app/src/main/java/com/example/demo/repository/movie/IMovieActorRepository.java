package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieActorRepository extends JpaRepository<MovieActor, Integer> {

    @Query(value = "select * from movie_actor where movie_id = ?1", nativeQuery = true)
    List<MovieActor> findAllMovieActorByMovieId(Integer id);
}
