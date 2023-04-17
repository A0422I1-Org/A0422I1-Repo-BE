package com.example.demo.service.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {
    List<Movie> findAllMovie();
}
