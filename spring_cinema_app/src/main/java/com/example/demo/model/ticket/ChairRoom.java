package com.example.demo.model.ticket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    public ChairRoom() {
    }

    public ChairRoom(Integer id, Boolean status, Boolean isDelete, Room room, Chair chair) {
        this.id = id;
        this.status = status;
        this.isDelete = isDelete;
        this.room = room;
        this.chair = chair;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public Boolean getDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(Boolean delete) {
//        isDelete = delete;
//    }
//
//    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }
//
//    public Chair getChair() {
//        return chair;
//    }
//
//    public void setChair(Chair chair) {
//        this.chair = chair;
//    }
}