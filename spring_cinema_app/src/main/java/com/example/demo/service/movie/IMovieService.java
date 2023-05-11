package com.example.demo.service.movie;

import com.example.demo.dto.MovieListViewDTO;
import com.example.demo.model.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<MovieListViewDTO> findOnShowingMovie();
    List<MovieListViewDTO> findUpcomingMovie();
    List<MovieListViewDTO> findMovieByName(String name);
}
