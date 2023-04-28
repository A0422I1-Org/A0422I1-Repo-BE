package com.example.demo.controller.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.movie.Movie;

import java.util.List;

@RestController
@RequestMapping("api/public/movie")
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
    @GetMapping("detail/{movieId}")
    public ResponseEntity<IMovieDetailDTO> getMovieDetailById(@PathVariable("movieId") Integer movieId) {
        IMovieDetailDTO movieDetailDTO = movieService.getMovieDetailByMovieId(movieId);
        if (movieDetailDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(movieDetailDTO, HttpStatus.OK);
    }

    @GetMapping("/list-movie-by-date-show-time")
    public List<Movie> getAllMovieByDateShowTime() {
        return movieService.findMoviesByStartDate();
    }
}
