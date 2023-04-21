package com.example.demo.service.movie;

<<<<<<< HEAD
import com.example.demo.model.movie.MovieType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMovieService {

=======
import java.util.List;

public interface IMovieService {
    List<?> findStatisticMovie();

    List<?> findStatisticMovieAcs();

    List<?> searchStatisticMovieByName(String nameMovie);
>>>>>>> 9a045a625d3d13fb64780ca2a9e534ec1d84ae82
}
