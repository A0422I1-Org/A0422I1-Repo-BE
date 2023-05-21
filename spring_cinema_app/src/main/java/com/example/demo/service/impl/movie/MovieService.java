package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.*;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    private IMovieRepository movieRepository;

    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    @Override
    public IMovieDetailDTO getMovieDetailByMovieId(Integer movieId) {
        movieRepository.getMovieByMovieId(movieId);
        return movieRepository.getMovieByMovieId(movieId);
    }

    /**
     * @return List<MovieListViewDTO>
     * @content find all on showing movie
     * @author PhuongLT
     */

    @Override
    public List<MovieListViewDTO> findOnShowingMovie() {
        List<Movie> movieList = movieRepository.getOnShowingMovie();
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
           movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;

    }

    /**
     * @return List<MovieListViewDTO>
     * @content find all upcoming movie
     * @author PhuongLT
     */

    @Override
    public List<MovieListViewDTO> findUpcomingMovie() {
        List<Movie> movieList = movieRepository.getUpComingMovie();
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
            movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;
    }

    /**
     * @return List<MovieListViewDTO>
     * @content find movie by name
     * @author PhuongLT
     */

    @Override
    public List<MovieListViewDTO> findMovieByName(String name) {
        List<Movie> movieList = movieRepository.findAllByIsDeleteFalseAndNameContainingIgnoreCase(name);
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
            movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;
    }

    /**
     * @return List<MovieBookingDTO>
     * @content find all the movies with showings
     * @author PhatVN
     */
    @Override
    public List<MovieBookingDTO> findMoviesByStartDate() {
        return movieRepository.findMoviesByStartDate();
    }

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
