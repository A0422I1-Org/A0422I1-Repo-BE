package com.example.demo.model.ticket;

import com.example.demo.model.customer.Customer;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @Column(columnDefinition = ("varchar(20)"))
    private String id;
    @NotNull
    private Double price;
    private Date bookDateTime;
    @NotNull
    private Boolean status;
    private Boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "customer_id", columnDefinition = ("varchar(20)"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "chair_room_id")
    private ChairRoom chairRoom;

    public Ticket() {
    }

    public Ticket(String id, Double price, Date bookDateTime, Boolean status, Boolean isDelete, Customer customer, ShowTime showTime, ChairRoom chairRoom) {
        this.id = id;
        this.price = price;
        this.bookDateTime = bookDateTime;
        this.status = status;
        this.isDelete = isDelete;
        this.customer = customer;
        this.showTime = showTime;
        this.chairRoom = chairRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBookDateTime() {
        return bookDateTime;
    }

    public void setBookDateTime(Date bookDateTime) {
        this.bookDateTime = bookDateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShowTime getShowtime() {
        return showTime;
    }

    public void setShowtime(ShowTime showtime) {
        this.showTime = showtime;
    }

    public ChairRoom getChairRoom() {
        return chairRoom;
    }

    public void setChairRoom(ChairRoom chairRoom) {
        this.chairRoom = chairRoom;
    }
}


