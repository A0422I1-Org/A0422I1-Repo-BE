package com.example.demo.controller.StatisticController;


import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
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
    ICustomerService customerService;

    @GetMapping("/movie-statistic-list")
    public ResponseEntity<Page<MovieDTO>> getListMovieStatistic(@PageableDefault(size = 5) Pageable pageable,
                                                                @RequestParam(defaultValue = "") String nameMovie,
                                                                @RequestParam(defaultValue = "desc") String statusSort) {
        Page<MovieDTO> movieDTOList;

        if (!(nameMovie.equals("")) && "desc".equals(statusSort) ) {
            movieDTOList = movieService.searchStatisticMovieByNameDesc(nameMovie, pageable);
            return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
        }else if (!(nameMovie.equals("")) && "acs".equals(statusSort)){
            movieDTOList = movieService.searchStatisticMovieByNameAcs(nameMovie, pageable);
            return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
        }

        if ("acs".equals(statusSort)) {
            movieDTOList = movieService.findStatisticMovieAcs(pageable);

        } else {
            movieDTOList = movieService.findStatisticMovieDesc(pageable);
        }
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
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
    public ResponseEntity<List<CustomerDTO>> searchCustomerStatisticListByName(@RequestParam(value = "nameCustomer", defaultValue = "") String nameCustomer,
                                                                               @RequestParam(value = "status", defaultValue = "") String status) {
        if ("".equals(nameCustomer)) {
            return new ResponseEntity<>(customerService.getListCustomerDTO(), HttpStatus.OK);
        } else if ("false".equals(status)) {
            return new ResponseEntity<>(customerService.searchCustomerStatisticListByNameAcs(nameCustomer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerService.searchCustomerStatisticListByNameDesc(nameCustomer), HttpStatus.OK);
        }
    }

}
