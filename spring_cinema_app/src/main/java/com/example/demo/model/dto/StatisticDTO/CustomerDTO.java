package com.example.demo.model.dto.StatisticDTO;

import com.example.demo.model.customer.Customer;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.stream.Collectors;

@Component

public class CustomerDTO implements Serializable {
    private String id;
    private String fullName;
    private double point;
    private Long ticket;
    private double money;
    private String email;
    private String phone;
    private String address;
    private String idCard;


    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.fullName = customer.getFullName();
        this.point = customer.getGetListPoint()
                .stream()
                .map(item -> item.getPoint())
                .collect(Collectors.summingDouble(Integer::doubleValue));
        this.ticket =  customer.getGetTicketList()
                .stream()
                .map(item -> item.getId()).count();
        this.money = customer.getGetTicketList()
                .stream()
                .map(item -> item.getPrice())
                .collect(Collectors.summingDouble(Double::doubleValue));

        this.email = customer.getEmail();
        this.phone = customer.getPhoneNumber();
        this.address = customer.getAddress();
        this.idCard = customer.getCardId();

    }


    public CustomerDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
