package com.example.demo.service.impl.movie;

import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {

    public final IMovieRepository iMovieRepository;

    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }


    @Override
    public Iterable<?> findOnShowingMovie() {
        return iMovieRepository.findOnShowingMovie();
    }

    @Override
    public Iterable<?> findUpcomingMovie() {
        return iMovieRepository.findUpcomingMovie();
    }

    @Override
    public Iterable<?> findAll() {
        return iMovieRepository.findAll();
    }

    @Override
    public Iterable<?> findMovieByName(String name) {
        return iMovieRepository.findMovieByName(name);
    }
}
