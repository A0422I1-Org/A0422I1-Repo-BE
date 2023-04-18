package com.example.demo.controller.statistic;

import com.example.demo.model.movie.MovieType;
import com.example.demo.service.impl.movie.MovieAndTypeService;
import com.example.demo.service.impl.movie.MovieTypeService;
import com.example.demo.service.impl.ticket.ShowTimeService;
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
public class StatisticCategoryMovieAndShowtimeController {
    @Autowired
    private MovieTypeService movieTypeService;
    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/testRequest")
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("testRequest here", HttpStatus.OK);
    }

    @GetMapping("/categoryMovie")
    public ResponseEntity<List<?>> getMovieTypeStatistic() {
        return new ResponseEntity<>(movieTypeService.statisticCategoryMovie(), HttpStatus.OK);
    }

    @GetMapping("/showtimeMovie")
    public ResponseEntity<List<?>> getMovieShowtimeStatistic() {
        return new ResponseEntity<>(showTimeService.statisticShowtime(), HttpStatus.OK);
    }
}
