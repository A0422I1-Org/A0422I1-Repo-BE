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
    private String nameChair;
    private Double price;
    private String email;
    private String image;

    public TicketViewDTO(Ticket ticket){
        this.id = ticket.getId();
        this.customerId = ticket.getCustomer().getId();
        this.fullName = ticket.getCustomer().getFullName();
        this.cardId = ticket.getCustomer().getCardId();
        this.phoneNumber = ticket.getCustomer().getPhoneNumber();
        this.nameMovie = ticket.getShowTime().getMovie().getName();
        this.screen = ticket.getChairRoom().getRoom().getScreen();
        this.startDate = ticket.getShowTime().getMovie().getStartDay();
        this.startTime = ticket.getShowTime().getStartTime();
        this.nameChair = ticket.getChairRoom().getChair().getName();
        this.price = ticket.getPrice();
        this.email = ticket.getCustomer().getEmail();
        this.image = ticket.getShowTime().getMovie().getImage();
    }

}
