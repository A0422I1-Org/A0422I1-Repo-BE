package com.example.demo.model.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
@Entity
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "movieType")
    @JsonBackReference
    private Set<MovieAndType> movieAndTypes;
    @NotNull
    private Boolean isDelete;

    public MovieType() {
    }

    public MovieType(Integer id, @NotNull String name, Set<MovieAndType> movieAndTypes, @NotNull Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.movieAndTypes = movieAndTypes;
        this.isDelete = isDelete;
    }
}
