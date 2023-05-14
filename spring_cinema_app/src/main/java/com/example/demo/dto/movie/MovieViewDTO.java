package com.example.demo.dto.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;


@Component
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

    public MovieViewDTO() {
    }

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
        this.isDelete = movie.getDelete();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeAmount() {
        return timeAmount;
    }

    public void setTimeAmount(Integer timeAmount) {
        this.timeAmount = timeAmount;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMovieStudio() {
        return movieStudio;
    }

    public void setMovieStudio(String movieStudio) {
        this.movieStudio = movieStudio;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
