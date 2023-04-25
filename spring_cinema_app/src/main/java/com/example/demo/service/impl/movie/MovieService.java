package com.example.demo.service.impl.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    /**
     * Get all Movie
     *
     * @param pageable
     * @return Page<Movie>
     *
     * @Author: DuHC
     */
    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    /**
     * Get all movie and sort decrease by ticket
     *
     * @param pageable
     * @return Page<MovieDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<MovieDTO> findStatisticMovieDesc(Pageable pageable) {
        return movieRepository.findStatisticMovieDesc(pageable);
    }

    /**
     * Get all movie and sort increase by ticket
     *
     * @param pageable
     * @return Page<MovieDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<MovieDTO> findStatisticMovieAcs(Pageable pageable) {
        return movieRepository.findStatisticMovieAcs(pageable);
    }

    /**
     * search movie by name and sort decrease by ticket
     *
     * @param pageable
     * @return Page<MovieDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie, Pageable pageable) {
        return movieRepository.searchStatisticMovieByNameDesc(nameMovie, pageable);
    }

    /**
     * search movie by name and sort increase by ticket
     *
     * @param pageable
     * @return Page<MovieDTO>
     *
     * @Author: DuHC
     */
    @Override
    public Page<MovieDTO> searchStatisticMovieByNameAcs(String nameMovie, Pageable pageable) {
        return movieRepository.searchStatisticMovieByNameAsc(nameMovie, pageable);
    }
}
