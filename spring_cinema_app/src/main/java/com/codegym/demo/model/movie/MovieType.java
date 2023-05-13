package com.codegym.demo.model.movie;

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
    @NotNull
    private Boolean isDelete;

    public MovieType() {
    }

    public MovieType(Integer id, @NotNull String name, @NotNull Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
    }
}
