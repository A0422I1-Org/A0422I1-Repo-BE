package com.example.demo.dto;

import com.example.demo.model.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketViewDTO {
    private String id;
    private String customerId;
    private String fullName;
    private String cardId;
    private String phoneNumber;
    private String nameMovie;
    private String screen;
    private Date startDate;
    private String startTime;
    private String endTime;
    private String nameChair;
    private String room;
    private Double price;
    private String email;
    private String image;
    private Date bookDateTime;

    public TicketViewDTO(Ticket ticket){
        this.id = ticket.getId();
        this.customerId = ticket.getCustomer().getId();
        this.fullName = ticket.getCustomer().getFullName();
        this.cardId = ticket.getCustomer().getCardId();
        this.phoneNumber = ticket.getCustomer().getPhoneNumber();
        this.nameMovie = ticket.getShowtime().getMovie().getName();
        this.screen = ticket.getChairRoom().getRoom().getScreen();
        this.startDate = ticket.getShowtime().getMovie().getStartDay();
        this.startTime = ticket.getShowtime().getStartTime();
        this.endTime = ticket.getShowtime().getEndTime();
        this.nameChair = ticket.getChairRoom().getChair().getName();
        this.price = ticket.getPrice();
        this.email = ticket.getCustomer().getEmail();
        this.image = ticket.getShowtime().getMovie().getImage();
        this.bookDateTime = ticket.getBookDateTime();
        this.room = ticket.getChairRoom().getRoom().getName();
    }

}
