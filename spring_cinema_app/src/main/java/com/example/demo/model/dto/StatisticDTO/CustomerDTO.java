package com.example.demo.model.dto.StatisticDTO;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.movie.Movie;
import com.example.demo.repository.customer.ICustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class CustomerDTO implements Serializable {
    private String id;
    private String fullName;
    private double point;
    private Long ticket;
    private double money;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.fullName = customer.getFullName();
        this.point = customer.getGetListPoint()
                .stream()
                .map(item -> item.getPoint())
                .collect(Collectors.summingDouble(Integer::doubleValue));
        this.ticket = customer.getGetTicketList()
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.counting());
        this.money = customer.getGetTicketList()
                .stream()
                .map(item -> item.getPrice())
                .collect(Collectors.summingDouble(Double::doubleValue));
    }


    public CustomerDTO() {
    }

    public CustomerDTO(String id, String fullName, double point, Long ticket, double money) {
        this.id = id;
        this.fullName = fullName;
        this.point = point;
        this.ticket = ticket;
        this.money = money;
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
}
