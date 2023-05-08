package com.example.demo.model.movie;

import com.example.demo.model.ticket.ShowTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String image;
    @DateTimeFormat
    private Date startDay;
    @NotNull
    private Integer timeAmount;
    @NotNull
    @Column(columnDefinition = ("text"))
    private String description;
    @NotNull
    private String status;
    @NotNull
    private String trailer;
    @NotNull
    private Double rating;
    @NotNull
    private String language;
    @NotNull
    private Boolean isDelete;

    public Movie() {
    }

    public Movie(Integer id, String name, String image, Date startDay, Integer timeAmount, String description, String status, String trailer, Double rating, String language, Boolean isDelete) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.startDay = startDay;
        this.timeAmount = timeAmount;
        this.description = description;
        this.status = status;
        this.trailer = trailer;
        this.rating = rating;
        this.language = language;
        this.isDelete = isDelete;
    }
}
