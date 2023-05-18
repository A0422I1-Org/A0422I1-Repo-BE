package com.example.demo.model.movie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RatingMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private double rating;
    private Boolean isDelete;


    public RatingMovie() {
    }

    public RatingMovie(String username, double rating, Boolean isDelete, Movie movie) {
        this.username = username;
        this.rating = rating;
        this.isDelete = isDelete;
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
