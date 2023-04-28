package com.example.demo.service.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    IMovieDetailDTO getMovieDetailByMovieId(Integer movieId);

    List<Movie> findMoviesByStartDate();
}
