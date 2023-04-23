package com.example.demo.service.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IMovieService {
    Page<Movie> findAll(Pageable pageable);

    Page<MovieDTO> findStatisticMovieDesc(Pageable pageable);

    Page<MovieDTO> findStatisticMovieAcs(Pageable pageable);

    Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie, Pageable pageable);

    Page<MovieDTO> searchStatisticMovieByNameAcs(String nameMovie, Pageable pageable);
}
