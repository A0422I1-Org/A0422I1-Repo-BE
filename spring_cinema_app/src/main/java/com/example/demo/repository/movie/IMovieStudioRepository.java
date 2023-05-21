package com.example.demo.repository.movie;

import com.example.demo.model.movie.MovieStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieStudioRepository extends JpaRepository<MovieStudio, Integer> {
}
