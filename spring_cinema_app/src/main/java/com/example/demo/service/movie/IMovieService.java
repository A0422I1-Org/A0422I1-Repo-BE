package com.example.demo.service.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> findStatisticMovie(int index);

    List<?> findStatisticMovieAcs();

    List<?> searchStatisticMovieByName(String nameMovie);
}
