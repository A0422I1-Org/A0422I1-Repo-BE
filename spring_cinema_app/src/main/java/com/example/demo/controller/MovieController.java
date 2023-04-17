package com.example.demo.controller;

import com.example.demo.model.movie.Movie;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema/movie")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/list-movie")
    public List<Movie> getAllMovie(){
        return movieService.findAllMovie();
    }
}
