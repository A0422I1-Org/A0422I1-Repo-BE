package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.MovieDetailDTO;
import com.example.demo.model.movie.*;
import com.example.demo.repository.movie.*;
import com.example.demo.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IMovieAndTypeRepository movieAndTypeRepository;

    @Autowired
    private IMovieActorRepository movieActorRepository;

    @Autowired
    private IMovieAndStudioRepository movieAndStudioRepository;

    @Autowired
    private IMovieDirectorRepository movieDirectorRepository;

    /**
     * @param movieId of movie
     * @return MovieDetailDTO
     * @content: get movie detail by id
     * @Author: ChuongLN
     */
    @Override
    public MovieDetailDTO getMovieDetailByMovieId(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie == null) {
            return null;
        }

        List<MovieType> movieTypes = new ArrayList<>();
        List<MovieAndType> movieAndTypes = movieAndTypeRepository.findAllMovieAndTypeByMovieId(movieId);
        for (MovieAndType movieAndType : movieAndTypes) {
            movieTypes.add(movieAndType.getMovieType());
        }

        List<Actor> actors = new ArrayList<>();
        List<MovieActor> movieActors = movieActorRepository.findAllMovieActorByMovieId(movieId);
        for (MovieActor movieActor : movieActors) {
            actors.add(movieActor.getActor());
        }

        List<MovieStudio> movieStudios = new ArrayList<>();
        List<MovieAndStudio> movieAndStudios = movieAndStudioRepository.findAllMovieAndStudioByMovieId(movieId);
        for (MovieAndStudio movieAndStudio : movieAndStudios) {
            movieStudios.add(movieAndStudio.getMovieStudio());
        }

        List<Director> directors = new ArrayList<>();
        List<MovieDirector> movieDirectors = movieDirectorRepository.findAllMovieDirectorByMovieId(movieId);
        for (MovieDirector movieDirector : movieDirectors) {
            directors.add(movieDirector.getDirector());
        }

        MovieDetailDTO movieDetailDTO = new MovieDetailDTO();
        movieDetailDTO.setId(movie.getId());
        movieDetailDTO.setName(movie.getName());
        movieDetailDTO.setImage(movie.getImage());
        movieDetailDTO.setStartDay(movie.getStartDay());
        movieDetailDTO.setTimeAmount(movie.getTimeAmount());
        movieDetailDTO.setDescription(movie.getDescription());
        movieDetailDTO.setStatus(movie.getStatus());
        movieDetailDTO.setTrailer(movie.getTrailer());
        movieDetailDTO.setRating(movie.getRating());
        movieDetailDTO.setLanguage(movie.getLanguage());
        movieDetailDTO.setIsDelete(movie.getIsDelete());

        movieDetailDTO.setMovieTypes(movieTypes);
        movieDetailDTO.setActors(actors);
        movieDetailDTO.setMovieStudios(movieStudios);
        movieDetailDTO.setDirectors(directors);

        return movieDetailDTO;
    }
}
