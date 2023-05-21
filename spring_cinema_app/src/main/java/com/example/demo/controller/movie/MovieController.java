package com.example.demo.controller.movie;

import com.example.demo.dto.movie.*;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.movie.Movie;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")


public class MovieController {



    @Autowired
    private IMovieService movieService;

    /**
     * @param movieId of movie
     * @return ResponseEntity<IMovieDetailDTO>
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    @GetMapping("/public/movie/detail/{movieId}")
    public ResponseEntity<IMovieDetailDTO> getMovieDetailById(@PathVariable("movieId") Integer movieId) {
        IMovieDetailDTO movieDetailDTO = movieService.getMovieDetailByMovieId(movieId);
        if (movieDetailDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movieDetailDTO, HttpStatus.OK);
    }

    /**
     * @return List<MovieListViewDTO>
     * @content find all on showing movie
     * @author PhuongLT
     */
    @GetMapping("/public/movie/list/onShowing")
    public ResponseEntity<List<MovieListViewDTO>> getAllOnShowingMovie(){
        List<MovieListViewDTO> movies = movieService.findOnShowingMovie();
        if (movies == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * @return List<MovieListViewDTO>
     * @content find all upcoming movie
     * @author PhuongLT
     */
    @GetMapping("/public/movie/list/upcoming")
    public ResponseEntity <List<MovieListViewDTO>> getUpcomingMovie(){
        List<MovieListViewDTO> movies = movieService.findUpcomingMovie();
        if (movies == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * @return List<MovieListViewDTO>
     * @content find movie by name
     * @author PhuongLT
     */
    @GetMapping("/public/movie/find")
    public ResponseEntity <List<MovieListViewDTO>> getMovieByName(@RequestParam(value = "name", defaultValue = "") String name) {
        List<MovieListViewDTO> movies = movieService.findMovieByName(name);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    /**
     * @return List<MovieBookingDTO>
     * @content Get all the movies with showings
     * @author PhatVN
     */
    @GetMapping("/public/movie/list-movie-by-date-show-time")
    public ResponseEntity<List<MovieBookingDTO>> getAllMovieByDateShowTime() {
        List<MovieBookingDTO> movieList = movieService.findMoviesByStartDate();
        if (movieList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }


    /**
     * @content Get all the movies in admin page
     * @author KhaiN
     */
    @GetMapping("/admin/movie")
    public ResponseEntity<Page<MovieViewDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name,
                                                      @RequestParam(name = "startDay", defaultValue = "") String startDay,
                                                      @RequestParam(name = "timeAmount", defaultValue = "") String timeAmount,
                                                      @RequestParam(name = "studios", defaultValue = "") String studios,
                                                      @PageableDefault(size = 5  ) Pageable pageable
    ) {
        return ResponseEntity.ok().body(movieService.findAllByNameAndByStartDayAndByTimeAmount(name,startDay,timeAmount,studios,pageable));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieViewDTO> findById(@PathVariable Integer id) throws NotFoundById {
        Movie movie = movieService.findById(id);
        return new ResponseEntity<>(new MovieViewDTO(movie),HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Integer> isDeleteById(@PathVariable("id")Integer id) {
        return new ResponseEntity<>(movieService.updateIsDeleteById(id), HttpStatus.OK);
    }

}
