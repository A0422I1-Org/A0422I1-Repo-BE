package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.ShowTime;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinema/showtime")
public class ShowTimeController {
    @Autowired
    IShowTimeService showTimeService;

    @GetMapping("/showtime-by-movie/{id}")
    public List<ShowTime> getShowTimeByIdMovie(@PathVariable("id") Integer id) {
        return showTimeService.findShowTimeByMovieId(id);
    }
}
