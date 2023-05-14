package com.example.demo.service.impl.movie;

import com.example.demo.error.NotFoundById;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dto.movie.MovieViewDTO;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


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

//    @Override
//    public Page<MovieViewDTO> findAll(Pageable pageable) {
//        return repository.findAll(pageable).map(MovieViewDTO::new);
//    }

    @Override
    public Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable) {
        if ("".equalsIgnoreCase(studios)) {
            return movieRepository.findAllByNameAndByStartDayAndByTimeAmount(name, startDay, timeAmount, pageable).map(MovieViewDTO::new);
        }
        return new PageImpl<>(movieRepository
                .findAllByThreeCondition(name, startDay, timeAmount)
                .stream()
                .map(MovieViewDTO::new)
                .filter(x -> x.getMovieStudio().toLowerCase().contains(studios.toLowerCase()))
                .collect(Collectors.toList()));
    }

    @Override
    @SneakyThrows
    public Movie findById(Integer id)throws NotFoundById {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return (movie.get());
        }
        throw new NotFoundById("Khong tim thay"+ id);
    }

    @Override
    public Integer updateIsDeleteById(Integer id) {
        return movieRepository.updateIsDeleteById(id);
    }
}
