package com.example.demo.dto.movie;

import com.example.demo.model.movie.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieDetailDTO {
    private Integer id;
    private String name;
    private String image;
    private Date startDay;
    private Integer timeAmount;
    private String description;
    private String status;
    private String trailer;
    private Double rating;
    private String language;
    private Boolean isDelete;

    private List<MovieType> movieTypes;
    private List<Actor> actors;
    private List<MovieStudio> movieStudios;
    private List<Director> directors;

    public MovieDetailDTO() {
    }

    public MovieDetailDTO(Integer id, String name, String image, Date startDay, Integer timeAmount, String description, String status, String trailer, Double rating, String language, Boolean isDelete, List<MovieType> movieTypes, List<Actor> actors, List<MovieStudio> movieStudios, List<Director> directors) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.startDay = startDay;
        this.timeAmount = timeAmount;
        this.description = description;
        this.status = status;
        this.trailer = trailer;
        this.rating = rating;
        this.language = language;
        this.isDelete = isDelete;
        this.movieTypes = movieTypes;
        this.actors = actors;
        this.movieStudios = movieStudios;
        this.directors = directors;
    }
}
