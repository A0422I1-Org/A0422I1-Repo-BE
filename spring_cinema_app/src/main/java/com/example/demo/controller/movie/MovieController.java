package com.example.demo.controller.movie;

import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.service.impl.movie.MovieService;
import com.example.demo.service.movie.IMovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("/*")
public class MovieController {
    IMovieService iMovieService;

    public MovieController(MovieService service) {
        this.iMovieService = service;
    }

    @RequestMapping("")
    public ResponseEntity<Page<MovieViewDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                                      @RequestParam(name = "startDay", defaultValue = "") String startDay,
                                                      @RequestParam(name = "timeAmount", defaultValue = "") String timeAmount,
                                                      @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok().body(iMovieService.findAllByNameAndByStartDayAndByTimeAmount(name,startDay,timeAmount,pageable));
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id")Integer id){
        return iMovieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Integer isDeleteById(@PathVariable("id")Integer id){
        return iMovieService.updateIsDeleteById(id);
    }
}
