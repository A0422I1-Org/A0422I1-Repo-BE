package com.example.demo.controller.statistic;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.impl.movie.MovieTypeService;
import com.example.demo.service.impl.ticket.ShowTimeService;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/admin")
public class StatisticController {

    @Autowired
    private IMovieService movieService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private MovieTypeService movieTypeService;
    @Autowired
    private ShowTimeService showTimeService;



    /**
     * Get a list movie or search and sort if param nameMovie and statusSort not null
     *
     * @param pageable page have size default = 5
     * @param nameMovie name of movie wanna search
     * @param statusSort status of sort
     * @return a page movieDTO
     *
     * @Author: DuHC
     */
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

    /**
     * Get a list customer or search and sort if param nameCustomer and statusSort not null
     *
     * @param pageable page object
     * @param nameCustomer name of customer
     * @param statusSort status sort
     * @return a list customer after statistic by ticket
     *
     * @Author: DuHC
     */
    @GetMapping("/customer-statistic-list")
    public ResponseEntity<Page<CustomerDTO>> getListCustomerStatistic(@PageableDefault(size = 5 )Pageable pageable,
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

    /**
     * Find customer rank after find by customerId
     *
     * @param customerId id of customer wanna find
     * @return rank of customer after find by customerId
     *
     * @Author: DuHC
     */
    @GetMapping("/get-rank-customer")
    public ResponseEntity<Integer> getRankCustomerById(@RequestParam String customerId){
        return new ResponseEntity<>(customerService.getRankCustomer(customerId),HttpStatus.OK);
    }

    /**
     * Get a list category movie by ticket , format date and sort by revenue
     * @return a page List<Map<String,Object>
     * @Author: NghiaDC
     */
    @GetMapping("/category-movie")
    public ResponseEntity<List<Map<String,Object>>> statisticCategoryMovie() {
        return new ResponseEntity<>(movieTypeService.statisticCategoryMovie(), HttpStatus.OK);
    }

    /**
     * Get a list showtime movie by ticket , format date and sort by revenue
     * @return a page List<Map<String,Object>
     * @Author: NghiaDC
     */
    @GetMapping("/showtime-movie")
    public ResponseEntity<List<Map<String, Object>>> getMovieShowtimeStatistic() {
        return new ResponseEntity<>(showTimeService.statisticShowtime(), HttpStatus.OK);
    }

}
