package com.example.demo.service.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.dto.movie.MovieListViewDTO;

import java.util.List;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    IMovieDetailDTO getMovieDetailByMovieId(Integer movieId);


    List<MovieListViewDTO> findOnShowingMovie();
    List<MovieListViewDTO> findUpcomingMovie();
    List<MovieListViewDTO> findMovieByName(String name);

    List<MovieBookingDTO> findMoviesByStartDate();
}
