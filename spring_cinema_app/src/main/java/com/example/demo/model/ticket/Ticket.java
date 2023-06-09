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
    private Date bookDateTime;
    @NotNull
    private Integer status;
    private Boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "customer_id", columnDefinition = ("varchar(20)"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime; // admin bị sai tên showtime

    @ManyToOne
    @JoinColumn(name = "chair_room_id")
    private ChairRoom chairRoom;

    public Ticket() {
    }


    public Ticket(String id, @NotNull Double price, Date bookDateTime, @NotNull Integer status, Boolean isDelete, Customer customer, ShowTime showTime, ChairRoom chairRoom) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public ChairRoom getChairRoom() {
        return chairRoom;
    }

    public void setChairRoom(ChairRoom chairRoom) {
        this.chairRoom = chairRoom;
    }
}

