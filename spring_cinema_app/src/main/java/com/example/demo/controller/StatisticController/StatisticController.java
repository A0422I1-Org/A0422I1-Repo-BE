package com.example.demo.controller.StatisticController;


import com.example.demo.service.impl.customer.CustomerService;
import com.example.demo.service.impl.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    MovieService movieService;
    @Autowired
    CustomerService customerService;


    @GetMapping("/movieList")
    public ResponseEntity<List<?>> getListMovieStatistic() {
        return new ResponseEntity<>(movieService.findStatisticMovie(), HttpStatus.OK);
    }

    @GetMapping("/movieListAcs")
    public ResponseEntity<List<?>> getListMovieStatisticAcs() {
        return new ResponseEntity<>(movieService.findStatisticMovieAcs(), HttpStatus.OK);
    }

    @GetMapping("/searchMovieList")
    public ResponseEntity<List<?>> searchListMovieStatisticByName(@RequestParam(value = "nameMovie", defaultValue = "") String nameMovie) {
        List<?> movieList = movieService.searchStatisticMovieByName(nameMovie);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/customerListPoint")
    public ResponseEntity<List<?>> getListCustomerStatisticPoint() {
        return new ResponseEntity<>(customerService.getListCustomerPoint(), HttpStatus.OK);
    }

    @GetMapping("/customerListTicket")
    public ResponseEntity<List<?>> getListCustomerStatisticTicket() {
        return new ResponseEntity<>(customerService.getListCustomerTicket(), HttpStatus.OK);
    }


}
