package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<MovieBookingDTO> findMoviesByStartDate() {
        return movieRepository.findMoviesByStartDate();
    }

}
