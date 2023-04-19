package com.example.demo.controller.movie;

import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/movie")
public class MovieController {
    public final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/list/onShowing")
    public ResponseEntity<Iterable<?>> getAllOnShowingMovie(){
        Iterable<?> movies = movieService.findOnShowingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/list/upcoming")
    public ResponseEntity <Iterable<?>> getUpcomingMovie(){
        Iterable<?> movies = movieService.findUpcomingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity <Iterable<?>> getUpcomingMovie(@RequestParam(value = "name", defaultValue = "") String name){
        Iterable<?> movies = movieService.findMovieByName(name);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
