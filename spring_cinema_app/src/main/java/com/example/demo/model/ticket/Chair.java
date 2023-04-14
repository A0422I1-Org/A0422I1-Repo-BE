package com.example.demo.model.ticket;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    private Boolean isDelete;

    @OneToMany(mappedBy = "chair")
    @JsonBackReference
    private Set<ChairRoom> chairRooms;

    public Chair() {
    }

    public Chair(Integer id, @NotNull String name, Boolean isDelete, Set<ChairRoom> chairRooms) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.chairRooms = chairRooms;
    }
}
