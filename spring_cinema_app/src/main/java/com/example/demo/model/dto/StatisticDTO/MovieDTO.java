package com.example.demo.model.dto.StatisticDTO;

import org.springframework.stereotype.Component;


@Component
public interface MovieDTO{
     String getName();
     double getTotalMoney();
     int getTotalTicket();

}
