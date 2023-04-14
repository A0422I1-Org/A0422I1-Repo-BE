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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String screen;

    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private Set<ChairRoom> chairRooms;

    private Boolean isDelete;


    public Room() {
    }

    public Room(Integer id, @NotNull String name, @NotNull String screen, Set<ChairRoom> chairRooms, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.screen = screen;
        this.chairRooms = chairRooms;
        this.isDelete = isDelete;
    }
}
