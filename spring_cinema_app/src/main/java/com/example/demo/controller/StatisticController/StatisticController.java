package com.example.demo.controller.StatisticController;


import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.service.impl.customer.CustomerService;
import com.example.demo.service.movie.IMovieService;
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
    IMovieService movieService;
    @Autowired
    CustomerService customerService;


    @GetMapping("/movie-statistic-list")
    public ResponseEntity<List<?>> getListMovieStatistic() {
        return new ResponseEntity<>(movieService.findStatisticMovie(), HttpStatus.OK);
    }

    @GetMapping("/movie-list-acs")
    public ResponseEntity<List<?>> getListMovieStatisticAcs() {
        return new ResponseEntity<>(movieService.findStatisticMovieAcs(), HttpStatus.OK);
    }

    @GetMapping("/search-movie-List")
    public ResponseEntity<List<?>> searchListMovieStatisticByName(@RequestParam(value = "nameMovie", defaultValue = "") String nameMovie) {
        List<?> movieList = movieService.searchStatisticMovieByName(nameMovie);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }


    @GetMapping("/customer-statistic-list")
    public ResponseEntity<List<CustomerDTO>> getListCustomerDTO() {
        return new ResponseEntity<>(customerService.getListCustomerDTO(), HttpStatus.OK);
    }

    @GetMapping("/customer-statistic-list-asc")
    public ResponseEntity<List<CustomerDTO>> getListCustomerDTOAcs() {
        return new ResponseEntity<>(customerService.getListCustomerDTOAcs(), HttpStatus.OK);
    }

    @GetMapping("/customer-statistic-list-search")
    public ResponseEntity<List<CustomerDTO>> searchCustomerStatisticListByName(@RequestParam(value = "nameCustomer", defaultValue = "") String nameCustomer) {
        return new ResponseEntity<>(customerService.searchCustomerStatisticListByName(nameCustomer), HttpStatus.OK);
    }

}
