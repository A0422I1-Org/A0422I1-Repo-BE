package com.example.demo.controller.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.dto.movie.MovieListViewDTO;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/public/movie/list/onShowing")
    public ResponseEntity<List<MovieListViewDTO>> getAllOnShowingMovie(){
        List<MovieListViewDTO> movies = movieService.findOnShowingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/public/movie/list/upcoming")
    public ResponseEntity <List<MovieListViewDTO>> getUpcomingMovie(){
        List<MovieListViewDTO> movies = movieService.findUpcomingMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/public/movie/find")
    public ResponseEntity <List<MovieListViewDTO>> getMovieByName(@RequestParam(value = "name", defaultValue = "") String name) {
        List<MovieListViewDTO> movies = movieService.findMovieByName(name);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    /**
     * @param
     * @return List<MovieBookingDTO>
     * @content Get all the movies with showings from today to the next three days
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
}
