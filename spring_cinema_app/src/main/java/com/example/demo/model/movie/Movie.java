package com.example.demo.model.movie;

import com.example.demo.model.ticket.ShowTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String image;
    @DateTimeFormat
    private Date startDay;
    @NotNull
    private String director;
    @NotNull
    private String actor;
    @NotNull
    private Integer timeAmuont;
    @NotNull
    private String movieStudio;
    @NotNull
    private String description;
    @NotNull
    private String status;
    @NotNull
    private String trailer;

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private Set<ShowTime> showTimes;

    @OneToMany(mappedBy = "movieT")
    @JsonBackReference
    private Set<MovieAndType>movieAndTypes;

    @OneToMany(mappedBy = "movieA")
    @JsonBackReference
    private Set<MovieActor> movieActors;

    @OneToMany(mappedBy = "movieS")
    @JsonBackReference
    private Set<MovieAndStudio> movieAndStudios;

    @OneToMany(mappedBy = "movieD")
    @JsonBackReference
    private Set<MovieDirector> movieDirectors;

    public Movie() {
    }

    public Movie(Integer id, @NotNull String name, @NotNull String image, Date startDay, @NotNull String director,
                 @NotNull String actor, @NotNull Integer timeAmuont, @NotNull String movieStudio,
                 @NotNull String description, @NotNull String status, @NotNull String trailer, Set<ShowTime> showTimes,
                 Set<MovieAndType> movieAndTypes, Set<MovieActor> movieActors,
                 Set<MovieAndStudio> movieAndStudios, Set<MovieDirector> movieDirectors) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.startDay = startDay;
        this.director = director;
        this.actor = actor;
        this.timeAmuont = timeAmuont;
        this.movieStudio = movieStudio;
        this.description = description;
        this.status = status;
        this.trailer = trailer;
        this.showTimes = showTimes;
        this.movieAndTypes = movieAndTypes;
        this.movieActors = movieActors;
        this.movieAndStudios = movieAndStudios;
        this.movieDirectors = movieDirectors;
    }
}
