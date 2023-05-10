package com.example.demo.service.movie;

import com.example.demo.dto.movie.MovieBookingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {

    List<MovieBookingDTO> findMoviesByShowTime();
}
