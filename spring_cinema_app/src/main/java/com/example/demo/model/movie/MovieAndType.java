package com.example.demo.model.movie;

import javax.persistence.*;


@Entity
public class MovieAndType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "movie_type_id")
    private MovieType movieType;

    public MovieAndType() {
    }

    public MovieAndType(Integer id, Movie movie, MovieType movieType) {
        this.id = id;
        this.movie = movie;
        this.movieType = movieType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}
