package com.example.demo.controller.StatisticController;


import com.example.demo.model.dto.StatisticDTO.CustomerDTO;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;

import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.impl.customer.CustomerService;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/admin")
public class StatisticController {

    @Autowired
    IMovieService movieService;
    @Autowired
    ICustomerService customerService;

    @GetMapping("/movie-statistic-list")
    public ResponseEntity<Page<MovieDTO>> getListMovieStatistic(@PageableDefault(size = 5) Pageable pageable,
                                                                @RequestParam(defaultValue = "") String nameMovie,
                                                                @RequestParam(defaultValue = "desc") String statusSort) {
        Page<MovieDTO> movieDTOPage;

        if (!(nameMovie.equals("")) && "desc".equals(statusSort) ) {
            movieDTOPage = movieService.searchStatisticMovieByNameDesc(nameMovie, pageable);
            return new ResponseEntity<>(movieDTOPage, HttpStatus.OK);
        }else if (!(nameMovie.equals("")) && "acs".equals(statusSort)){
            movieDTOPage = movieService.searchStatisticMovieByNameAcs(nameMovie, pageable);
            return new ResponseEntity<>(movieDTOPage, HttpStatus.OK);
        }

        if ("acs".equals(statusSort)) {
            movieDTOPage = movieService.findStatisticMovieAcs(pageable);

        } else {
            movieDTOPage = movieService.findStatisticMovieDesc(pageable);
        }
        return new ResponseEntity<>(movieDTOPage, HttpStatus.OK);
    }

    @GetMapping("/customer-statistic-list")
    public ResponseEntity<Page<CustomerDTO>> getListCustomerStatistic(@PageableDefault(size = 5 , sort = "getTicketList")Pageable pageable,
                                                                @RequestParam(defaultValue = "") String nameCustomer,
                                                                @RequestParam(defaultValue = "desc") String statusSort) {
        Page<CustomerDTO> customerDTOPage;

        if (!(nameCustomer.equals("")) && "desc".equals(statusSort) ) {
            customerDTOPage = customerService.searchCustomerStatisticListByNameDesc(nameCustomer, pageable);
            return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
        }else if (!(nameCustomer.equals("")) && "acs".equals(statusSort)){
            customerDTOPage = customerService.searchCustomerStatisticListByNameAcs(nameCustomer, pageable);
            return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
        }

        if ("acs".equals(statusSort)) {
            customerDTOPage = customerService.getListCustomerDTOAcs(pageable);

        } else {
            customerDTOPage = customerService.getListCustomerDTODesc(pageable);
        }
        return new ResponseEntity<>(customerDTOPage, HttpStatus.OK);
    }

    @GetMapping("/get-rank-customer")
    public ResponseEntity<Integer> getRankCustomerById(@RequestParam String customerId){
        return new ResponseEntity<Integer>(customerService.getRankCustomer(customerId),HttpStatus.OK);
    }


}
