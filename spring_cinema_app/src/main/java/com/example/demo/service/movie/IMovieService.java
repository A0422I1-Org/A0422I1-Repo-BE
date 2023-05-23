package com.example.demo.service.movie;

import com.example.demo.dto.movie.*;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IMovieService {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    IMovieDetailDTO getMovieDetailByMovieId(Integer movieId);


    /**
     * @return List<MovieListViewDTO>
     * @content find all on showing movie
     * @author PhuongLT
     */
    List<MovieListViewDTO> findOnShowingMovie();
    /**
     * @return List<MovieListViewDTO>
     * @content find all upcoming movie
     * @author PhuongLT
     */
    List<MovieListViewDTO> findUpcomingMovie();
    /**
     * @return List<MovieListViewDTO>
     * @content find movie by name
     * @author PhuongLT
     */
    List<MovieListViewDTO> findMovieByName(String name);

    List<MovieBookingDTO> findMoviesByStartDate();

/**
 * admin
 */
Page<Movie> findAll(Pageable pageable);

    Page<MovieDTO> findStatisticMovieDesc(Pageable pageable);

    Page<MovieDTO> findStatisticMovieAcs(Pageable pageable);

    Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie, Pageable pageable);

    Page<MovieDTO> searchStatisticMovieByNameAcs(String nameMovie, Pageable pageable);


    /**
     * @author KhaiN
     */

    Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable);

    Movie findById(Integer id) throws NotFoundById;

    Integer updateIsDeleteById(Integer id);
}
