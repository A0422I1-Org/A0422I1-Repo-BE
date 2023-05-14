package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {
}
