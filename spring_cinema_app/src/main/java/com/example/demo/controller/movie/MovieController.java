package com.example.demo.controller.movie;

import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/list-movie-by-date-show-time")
    public ResponseEntity<List<MovieBookingDTO>> getAllMovieByDateShowTime() {
        List<MovieBookingDTO> movieList = movieService.findMoviesByStartDate();
        if (movieList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);

    }

}
