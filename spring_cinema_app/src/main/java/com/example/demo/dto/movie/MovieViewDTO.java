package com.example.demo.dto.movie;

import com.example.demo.model.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieViewDTO implements Serializable {
    private Integer id;
    private Integer timeAmount;
    private Date startDay;
    private String movieStudio;

    public MovieViewDTO(Movie movie){
        this.id = movie.getId();
        this.timeAmount = movie.getTimeAmount();
        this.startDay = movie.getStartDay();
        this.movieStudio = movie.getMovieAndStudios().getMovieStudio().getName();
    }
}
