package com.example.demo.service.impl.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Page<MovieDTO> findStatisticMovieDesc(Pageable pageable) {
        return movieRepository.findStatisticMovieDesc(pageable);
    }

    @Override
    public Page<MovieDTO> findStatisticMovieAcs(Pageable pageable) {
        return movieRepository.findStatisticMovieAcs(pageable);
    }

    @Override
    public Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie, Pageable pageable) {
        return movieRepository.searchStatisticMovieByNameDesc(nameMovie, pageable);
    }

    @Override
    public Page<MovieDTO> searchStatisticMovieByNameAcs(String nameMovie, Pageable pageable) {
        return movieRepository.searchStatisticMovieByNameAsc(nameMovie, pageable);
    }
}
