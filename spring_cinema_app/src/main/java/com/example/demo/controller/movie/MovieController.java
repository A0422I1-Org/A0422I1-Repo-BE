package com.example.demo.controller.movie;

import com.example.demo.dto.MovieListViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/public/movie")
public class MovieController {

    public final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/list/onShowing")
    public ResponseEntity<List<MovieListViewDTO>> getAllOnShowingMovie(){
        List<MovieListViewDTO> movies = movieService.findOnShowingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/list/upcoming")
    public ResponseEntity <List<MovieListViewDTO>> getUpcomingMovie(){
        List<MovieListViewDTO> movies = movieService.findUpcomingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity <List<MovieListViewDTO>> getMovieByName(@RequestParam(value = "name", defaultValue = "") String name){
        List<MovieListViewDTO> movies = movieService.findMovieByName(name);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
