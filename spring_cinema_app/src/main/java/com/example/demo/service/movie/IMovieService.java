package com.example.demo.service.movie;

import java.util.List;

public interface IMovieService {
    List<?> findStatisticMovie();

    List<?> findStatisticMovieAcs();

    List<?> searchStatisticMovieByName(String nameMovie);
}
