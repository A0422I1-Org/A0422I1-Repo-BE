package com.example.demo.service.impl.movie;

import com.example.demo.dto.MovieListViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    public final IMovieRepository iMovieRepository;

    @Autowired
    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }


    @Override
    public List<MovieListViewDTO> findOnShowingMovie() {
        List<Movie> movieList = iMovieRepository.findAllByIsDeleteFalseAndStatusEquals("1");
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
           movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;

    }

    @Override
    public List<MovieListViewDTO> findUpcomingMovie() {
        List<Movie> movieList = iMovieRepository.findAllByIsDeleteFalseAndStatusEquals("0");
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
            movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;
    }

    @Override
    public List<MovieListViewDTO> findMovieByName(String name) {
        List<Movie> movieList = iMovieRepository.findAllByIsDeleteFalseAndNameContainingIgnoreCase(name);
        List<MovieListViewDTO> movieListViewDTOS = new ArrayList<>();
        for (int i = 0 ; i<movieList.size();i++){
            movieListViewDTOS.add(new MovieListViewDTO(movieList.get(i)));
        }
        movieListViewDTOS.sort((o1, o2) -> o2.getStartDay().compareTo(o1.getStartDay()));
        return movieListViewDTOS;
    }
}
