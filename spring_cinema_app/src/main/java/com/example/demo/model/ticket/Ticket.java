package com.example.demo.model.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

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

    public Ticket(String id, @NotNull Double price, Boolean isDelete, Customer customer, ShowTime showTime,
                  ChairRoom chairRoom) {
        this.id = id;
        this.price = price;
        this.isDelete = isDelete;
        this.customer = customer;
        this.showTime = showTime;
        this.chairRoom = chairRoom;
    }
}
