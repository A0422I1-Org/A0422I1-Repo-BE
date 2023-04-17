package com.example.demo.model.movie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MovieDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movieD;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public MovieDirector() {
    }

    public MovieDirector(Integer id, Movie movieD, Director director) {
        this.id = id;
        this.movieD = movieD;
        this.director = director;
    }
}
