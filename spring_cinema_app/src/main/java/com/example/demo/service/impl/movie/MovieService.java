package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository repository;

//    @Override
//    public Page<MovieViewDTO> findAll(Pageable pageable) {
//        return repository.findAll(pageable).map(MovieViewDTO::new);
//    }

    @Override
    public Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, Pageable pageable) {
        return repository.findAllByNameAndByStartDayAndByTimeAmount(name,startDay,timeAmount,pageable).map(MovieViewDTO::new);
    }

    @Override
    @SneakyThrows
    public Movie findById(Integer id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()){
            return (movie.get());
        }
        throw new Exception("");
    }

    @Override
    public Integer updateIsDeleteById(Integer id) {
        return repository.updateIsDeleteById(id);
    }
}
