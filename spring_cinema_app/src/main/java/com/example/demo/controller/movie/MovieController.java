package com.example.demo.controller.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieDetailDTO, HttpStatus.OK);
    }
}
