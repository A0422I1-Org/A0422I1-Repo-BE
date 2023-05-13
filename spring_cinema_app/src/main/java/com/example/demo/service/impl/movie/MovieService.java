package com.example.demo.service.impl.movie;


import com.example.demo.dto.movie.MovieViewDTO;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.movie.IMovieRepository;
import com.example.demo.service.movie.IMovieService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository repository;

//    @Override
//    public Page<MovieViewDTO> findAll(Pageable pageable) {
//        return repository.findAll(pageable).map(MovieViewDTO::new);
//    }

    @Override
    public Page<MovieViewDTO> findAllByNameAndByStartDayAndByTimeAmount(String name, String startDay, String timeAmount, String studios, Pageable pageable) {
        if ("".equalsIgnoreCase(studios)) {
            return repository.findAllByNameAndByStartDayAndByTimeAmount(name, startDay, timeAmount, pageable).map(MovieViewDTO::new);
        }
        return new PageImpl<>(repository
                .findAllByThreeCondition(name, startDay, timeAmount)
                .stream()
                .map(MovieViewDTO::new)
                .filter(x -> x.getMovieStudio().toLowerCase().contains(studios.toLowerCase()))
                .collect(Collectors.toList()));
    }

    @Override
    @SneakyThrows
    public Movie findById(Integer id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()) {
            return (movie.get());
        }
        throw new Exception("");
    }

    @Override
    public Integer updateIsDeleteById(Integer id) {
        return repository.updateIsDeleteById(id);
    }
}
