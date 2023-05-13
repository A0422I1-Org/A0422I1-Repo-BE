package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.dto.movie.MovieListViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<MovieListViewDTO> findOnShowingMovie() {
        List<Movie> movieList = movieRepository.findAllByIsDeleteFalseAndStatusEquals("1");
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
           movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;

    }

    @Override
    public List<MovieListViewDTO> findUpcomingMovie() {
        List<Movie> movieList = movieRepository.findAllByIsDeleteFalseAndStatusEquals("0");
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
            movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;
    }

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
}
