package com.example.demo.model.movie;

import com.example.demo.model.ticket.ShowTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String image;

    @NotBlank
    @DateTimeFormat
    private Date startDay;

    @NotBlank
    @NotNull
    private Integer timeAmount;

    @NotBlank
    @NotNull
    @Column(columnDefinition = ("text"))
    private String description;

    @NotBlank
    @NotNull
    private String status;

    @NotBlank
    @NotNull
    private String trailer;

    @NotBlank
    @NotNull
    private Double rating;

    @NotBlank
    @NotNull
    private String language;

    @NotBlank
    @NotNull
    private Boolean isDelete;

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

    public Movie(Integer id, String name, String image, Date startDay, Integer timeAmount, String description, String status, String trailer, Double rating, String language, Boolean isDelete, Set<ShowTime> showTimes, Set<MovieAndType> movieAndTypes, Set<MovieActor> movieActors, Set<MovieAndStudio> movieAndStudios, Set<MovieDirector> movieDirectors) {
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
        this.showTimes = showTimes;
        this.movieAndTypes = movieAndTypes;
        this.movieActors = movieActors;
        this.movieAndStudios = movieAndStudios;
        this.movieDirectors = movieDirectors;
    }
}
