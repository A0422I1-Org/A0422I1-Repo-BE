package com.example.demo.model.movie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MovieStudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean isDelete;


    public MovieStudio() {
    }

    public MovieStudio(Integer id, String name, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;

    }
}
