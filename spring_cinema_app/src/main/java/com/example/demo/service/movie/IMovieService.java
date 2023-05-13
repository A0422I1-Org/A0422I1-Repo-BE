package com.example.demo.service.movie;

import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.model.movie.Movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IMovieService {
    Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable);

    Movie findById(Integer id);

    Integer updateIsDeleteById(Integer id);
}
