package com.example.demo.controller.movie;

import com.example.demo.dto.movie.MovieDetailDTO;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    /**
     * @param movieId of movie
     * @return MovieDetailDTO
     * @content: get movie detail by movieId
     * @Author: ChuongLN
     */
    @GetMapping("detail/{movieId}")
    public ResponseEntity<MovieDetailDTO> getMovieDetailById(@PathVariable("movieId") Integer movieId) {
        MovieDetailDTO movieDetailDTO = movieService.getMovieDetailByMovieId(movieId);
        if (movieDetailDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieDetailDTO, HttpStatus.OK);
    }
}
