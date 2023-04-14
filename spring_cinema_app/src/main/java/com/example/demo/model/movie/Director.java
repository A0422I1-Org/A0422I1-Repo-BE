package com.example.demo.model.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean isDelete;

    @OneToMany(mappedBy = "director")
    @JsonBackReference
    private Set<MovieDirector> movieDirectors;

    public Director() {
    }

    public Director(Integer id, String name, Boolean isDelete, Set<MovieDirector> movieDirectors) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.movieDirectors = movieDirectors;
    }
}
