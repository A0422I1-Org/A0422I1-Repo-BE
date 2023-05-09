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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Integer getTimeAmount() {
        return timeAmount;
    }

    public void setTimeAmount(Integer timeAmount) {
        this.timeAmount = timeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
