package com.example.demo.model.customer;

import com.example.demo.model.movie.Movie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer point;
    @DateTimeFormat
    @NotNull
    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id",columnDefinition = ("varchar(45)"))
    private Customer customers;

    private Boolean isDelete;


    public Point() {
    }

    public Point(Integer id, Integer point, @NotNull Date date, String description, Customer customers, Boolean isDelete) {
        this.id = id;
        this.point = point;
        this.date = date;
        this.description = description;
        this.customers = customers;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

}
