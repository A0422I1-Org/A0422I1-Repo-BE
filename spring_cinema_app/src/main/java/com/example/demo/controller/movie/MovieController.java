package com.example.demo.controller.movie;

import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.movie.Movie;
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

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4200")
public class MovieController {
    @Autowired
    IMovieService iMovieService;

    public MovieController(MovieService service) {
        this.iMovieService = service;
    }

    @GetMapping("/movie")
    public ResponseEntity<Page<MovieViewDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                                      @RequestParam(name = "startDay", defaultValue = "") String startDay,
                                                      @RequestParam(name = "timeAmount", defaultValue = "") String timeAmount,
                                                      @RequestParam(name = "studios", defaultValue = "") String studios,
                                                      @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok().body(iMovieService.findAllByNameAndByStartDayAndByTimeAmount(name,startDay,timeAmount,studios,pageable));
    }

    @GetMapping("/movie/{id}")
    private ResponseEntity<MovieViewDTO> findById(@PathVariable Integer id)throws NotFoundById {
        Movie movie = iMovieService.findById(id);
        return new ResponseEntity<>(new MovieViewDTO(movie),HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    private ResponseEntity<Integer> isDeleteById(@PathVariable("id")Integer id) {
        return new ResponseEntity<>(iMovieService.updateIsDeleteById(id), HttpStatus.OK);
    }

}
