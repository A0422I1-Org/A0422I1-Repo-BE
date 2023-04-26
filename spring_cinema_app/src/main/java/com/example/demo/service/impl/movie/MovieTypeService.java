package com.example.demo.service.impl.movie;


import com.example.demo.repository.movie.IMovieTypeRepository;
import com.example.demo.service.movie.IMovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieTypeService implements IMovieTypeService {
    @Autowired
    IMovieTypeRepository movieTypeRepository;

    @Override
    public List<Map<String,Object>> statisticCategoryMovie() {
        return movieTypeRepository.statisticCategoryMovie();
    }
}
