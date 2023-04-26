package com.example.demo.controller.ticket;

import com.example.demo.model.ticket.ShowTime;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/showtime")
@CrossOrigin(origins = "http://localhost:4200")
public class ShowTimeController {
    @Autowired
    IShowTimeService showTimeService;

    @GetMapping("/showtime-by-movie/{id}")
    public List<ShowTime> getShowTimeByIdMovie(@PathVariable("id") Integer id) {
        return showTimeService.findShowTimeByMovieId(id);
    }

    @GetMapping("/showtime-by-id/{id}")
    public ShowTime getShowTimeById(@PathVariable("id") Integer id) {
        return showTimeService.findShowTimeById(id);
    }

}
