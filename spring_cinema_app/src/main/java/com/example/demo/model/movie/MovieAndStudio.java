package com.example.demo.model.movie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MovieAndStudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "movie_studio_id")
    private MovieStudio movieStudio;

    public MovieAndStudio() {
    }

    public MovieAndStudio(Integer id, Movie movie, MovieStudio movieStudio) {
        this.id = id;
        this.movie = movie;
        this.movieStudio = movieStudio;
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

    public MovieStudio getMovieStudio() {
        return movieStudio;
    }

    public void setMovieStudio(MovieStudio movieStudio) {
        this.movieStudio = movieStudio;
    }
}
