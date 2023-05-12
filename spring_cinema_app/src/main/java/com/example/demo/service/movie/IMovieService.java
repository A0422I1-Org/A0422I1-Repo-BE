package com.example.demo.service.movie;

<<<<<<< HEAD
import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.model.movie.Movie;
import java.util.List;
import com.example.demo.dto.movie.MovieListViewDTO;
import com.example.demo.dto.movie.MovieBookingDTO;
import org.springframework.stereotype.Service;

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
