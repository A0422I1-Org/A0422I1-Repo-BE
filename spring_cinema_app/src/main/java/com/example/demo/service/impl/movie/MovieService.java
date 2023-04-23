package com.example.demo.service.impl.movie;

import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<Movie> findMoviesByStartDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate threeDaysLater = currentDate.plusDays(3);
        return movieRepository.findMoviesByStartDate(threeDaysLater);
    }

}
