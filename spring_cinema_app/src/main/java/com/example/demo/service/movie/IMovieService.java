package com.example.demo.service.movie;

import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.movie.Movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IMovieService {
    /*
    * KhaiN admin movie-list-delete
    * */

    Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable);

    Movie findById(Integer id) throws NotFoundById;

    Integer updateIsDeleteById(Integer id);
}
