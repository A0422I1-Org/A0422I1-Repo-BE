package com.example.demo.model.ticket;

import com.example.demo.model.movie.Movie;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;



@Entity
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat
    @NotNull
    private Date date;
    @NotNull
    private String startTime;
    private String endTime;
    @NotNull
    private Boolean soldOut;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    private Boolean isDelete;

    public ShowTime() {
    }

    public ShowTime(Integer id, @NotNull Date date, @NotNull String startTime, String endTime,
                    @NotNull Boolean soldOut, Movie movie, Boolean isDelete) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.soldOut = soldOut;
        this.movie = movie;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(Boolean soldOut) {
        this.soldOut = soldOut;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

}
