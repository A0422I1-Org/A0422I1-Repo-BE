package com.example.demo.service.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    public IMovieDetailDTO getMovieDetailByMovieId(Integer movieId);
}
