package com.example.demo.model.ticket;

import com.example.demo.model.movie.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
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
}
