package com.example.demo.service.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.model.movie.Movie;
import java.util.List;
import com.example.demo.dto.movie.MovieListViewDTO;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    IMovieDetailDTO getMovieDetailByMovieId(Integer movieId);

    List<Movie> findMoviesByStartDate();


    List<MovieListViewDTO> findOnShowingMovie();
    List<MovieListViewDTO> findUpcomingMovie();
    List<MovieListViewDTO> findMovieByName(String name);
}
