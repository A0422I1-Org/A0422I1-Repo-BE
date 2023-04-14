package com.example.demo.model.ticket;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class ChairRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;
    private Boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    @OneToMany(mappedBy = "chairRoom")
    @JsonBackReference
    private Set<Ticket> tickets;

    public ChairRoom() {
    }

    public ChairRoom(Integer id, Boolean status, Boolean isDelete, Room room, Chair chair, Set<Ticket> tickets) {
        this.id = id;
        this.status = status;
        this.isDelete = isDelete;
        this.room = room;
        this.chair = chair;
        this.tickets = tickets;
    }
}
