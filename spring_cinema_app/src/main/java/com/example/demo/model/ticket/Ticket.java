package com.example.demo.model.ticket;

import com.example.demo.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "customer_id", columnDefinition = ("varchar(20)"))
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "chair_room_id")
    private ChairRoom chairRoom;

}
