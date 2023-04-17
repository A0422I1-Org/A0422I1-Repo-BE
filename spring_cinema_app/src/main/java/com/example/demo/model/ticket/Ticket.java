package com.example.demo.model.ticket;

import com.example.demo.model.customer.Customer;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
public class Ticket {
    @Id
    @Column(columnDefinition = ("varchar(20)"))
    private String id;
    @NotNull
    private Double price;
    private Date book_datetime;
    @NotNull
    private Boolean status;
    private Boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "customer_id",columnDefinition = ("varchar(20)"))
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "employee_id",columnDefinition = ("varchar(20)"))
//    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "chair_room_id")
    private ChairRoom chairRoom;

    public Ticket() {
    }

    public Ticket(String id, Double price, Date book_datetime, Boolean status, Boolean isDelete, Customer customer, ShowTime showTime, ChairRoom chairRoom) {
        this.id = id;
        this.price = price;
        this.book_datetime = book_datetime;
        this.status = status;
        this.isDelete = isDelete;
        this.customer = customer;
        this.showTime = showTime;
        this.chairRoom = chairRoom;
    }
}
