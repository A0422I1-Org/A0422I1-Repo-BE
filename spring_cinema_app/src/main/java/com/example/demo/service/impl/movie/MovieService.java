package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.repository.movie.*;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        return movieRepository.getMovieByMovieId(movieId);
    }
}
