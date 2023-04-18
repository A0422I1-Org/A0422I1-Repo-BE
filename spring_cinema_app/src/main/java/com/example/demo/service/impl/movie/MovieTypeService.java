package com.example.demo.service.impl.movie;

import com.example.demo.model.movie.MovieType;
import com.example.demo.repository.movie.IMovieTypeRepository;
import com.example.demo.service.movie.IMovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTypeService implements IMovieTypeService {
    @Autowired
    IMovieTypeRepository movieTypeRepository;


    @Override
    public List<?> statisticCategoryMovie() {
        return movieTypeRepository.statisticCategoryMovie();
    }


}
