package com.example.demo.service.movie;

import com.example.demo.dto.movie.MovieDetailDTO;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return MovieDetailDTO
     * @content get movie detail by id
     * @Author ChuongLN
     */
    public MovieDetailDTO getMovieDetailByMovieId(Integer movieId);
}
