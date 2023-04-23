package com.example.demo.controller.StatisticController;


import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.service.impl.customer.CustomerService;
import com.example.demo.service.impl.movie.MovieService;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    MovieService movieService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/movie-statistic-list-test")
    public ResponseEntity<Page<Movie>> getListMovieStatistictest(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok().body(movieService.findAll(pageable));
    }

    @GetMapping("/movie-statistic-list")
    public ResponseEntity<List<MovieDTO>> getListMovieStatistic(@RequestParam(value = "")int index ) {
        List<MovieDTO> movieDTOList = movieService.findStatisticMovie(index);
        if (movieDTOList.isEmpty()){
            return new ResponseEntity<List<MovieDTO>>(movieDTOList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MovieDTO>>(movieDTOList, HttpStatus.OK);
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
    public ResponseEntity<List<CustomerDTO>> searchCustomerStatisticListByName(@RequestParam(value = "nameCustomer", defaultValue = "") String nameCustomer
            , @RequestParam(value = "status", defaultValue = "") String status) {
        if ("".equals(nameCustomer)) {
            return new ResponseEntity<>(customerService.getListCustomerDTO(), HttpStatus.OK);
        } else if ("false".equals(status)) {
            return new ResponseEntity<>(customerService.searchCustomerStatisticListByNameAcs(nameCustomer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerService.searchCustomerStatisticListByNameDesc(nameCustomer), HttpStatus.OK);
        }
    }

}
