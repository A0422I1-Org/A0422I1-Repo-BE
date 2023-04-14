package com.example.demo.model.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class MovieStudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean isDelete;

    @OneToMany(mappedBy = "movieStudio")
    @JsonBackReference
    private Set<MovieAndStudio> movieAndStudios;

    public MovieStudio() {
    }

    public MovieStudio(Integer id, String name, Boolean isDelete, Set<MovieAndStudio> movieAndStudios) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.movieAndStudios = movieAndStudios;
    }
}
