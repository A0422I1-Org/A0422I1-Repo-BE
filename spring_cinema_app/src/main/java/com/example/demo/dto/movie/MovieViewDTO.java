package com.example.demo.dto.movie;

import com.example.demo.model.movie.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieViewDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer timeAmount;
    private Date startDay;
    private String image;
    private String movieStudio;
    private String movieActor;
    private String movieType;
    private String movieDirector;
    private Boolean isDelete;
    public MovieViewDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.timeAmount = movie.getTimeAmount();
        this.startDay = movie.getStartDay();
        this.image = movie.getImage();
        this.movieStudio = movie.getGetListStudio()
                .stream()
                .map(item -> item.getMovieStudio().getName())
                .collect(Collectors.joining(", "));
        this.movieActor = movie.getGetListActor()
                .stream()
                .map(item -> item.getActor().getName())
                .collect(Collectors.joining(", "));
        this.movieType = movie.getGetListType()
                .stream()
                .map(item -> item.getMovieType().getName())
                .collect(Collectors.joining(", "));
        this.movieDirector = movie.getGetListDirector()
                .stream()
                .map(item -> item.getDirector().getName())
                .collect(Collectors.joining(", "));
        this.isDelete = movie.getIsDelete();
    }
}
