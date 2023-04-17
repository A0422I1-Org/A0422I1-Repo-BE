package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieActorRepository extends JpaRepository<MovieActor,Integer> {
}
