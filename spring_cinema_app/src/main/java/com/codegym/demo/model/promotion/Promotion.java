package com.codegym.demo.model.promotion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String name;
    @DateTimeFormat
    @NotNull
    private Date time;
    @NotNull
    private Double saleOff;
    @Column(columnDefinition = ("varchar(255)"))
    @NotNull
    private String description;

    private Boolean isDelete;

    public Promotion() {
    }

    public Promotion(Integer id, @NotNull String name,
                     @NotNull Date time, @NotNull Double saleOff,
                     @NotNull String description, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.saleOff = saleOff;
        this.description = description;
        this.isDelete = isDelete;
    }
}
