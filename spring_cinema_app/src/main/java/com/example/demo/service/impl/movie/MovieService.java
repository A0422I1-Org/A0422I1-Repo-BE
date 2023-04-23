package com.example.demo.service.impl.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public List<MovieDTO> findStatisticMovie(int index) {
        return movieRepository.findStatisticMovie(index);
    }

    @Override
    public List<?> findStatisticMovieAcs() {
        return movieRepository.findStatisticMovieAcs();
    }

    @Override
    public List<?> searchStatisticMovieByName(String nameMovie) {
        return movieRepository.searchStatisticMovieByName(nameMovie);
    }
}
