package com.example.demo.model.customer;

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
}
