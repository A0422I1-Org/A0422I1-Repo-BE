package com.codegym.demo.model.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean isDelete;

    public Actor() {
    }

    public Actor(Integer id, String name, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
    }
}
