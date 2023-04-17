package com.example.demo.controller;

import com.example.demo.service.impl.movie.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movieList")
    public ResponseEntity<List<?>> getListMovieStatistic(){
        return new ResponseEntity<>(movieService.findStatisticMovie(), HttpStatus.OK);
    }

}
