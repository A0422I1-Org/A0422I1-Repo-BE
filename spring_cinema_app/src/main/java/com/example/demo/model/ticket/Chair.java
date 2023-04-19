package com.example.demo.model.ticket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    public Chair() {
    }

    public Chair(Integer id, @NotNull String name, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;

    }
}
