package com.example.demo.controller.ticket;

import com.example.demo.dto.ticket.ShowTimeBookingDTO;
import com.example.demo.model.ticket.ShowTime;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ShowTimeController {
    @Autowired
    IShowTimeService showTimeService;

    /**
     * @param
     * @return List<ShowTimeBookingDTO>
     * @content get all showtime of movie
     * @author PhatVN
     */
    @GetMapping("/public/showtime/showtime-by-movie/{id}")
    public ResponseEntity<List<ShowTimeBookingDTO>> getShowTimeByIdMovie(@PathVariable("id") Integer id) {
        List<ShowTimeBookingDTO> showTimeList = showTimeService.findShowTimeByMovieId(id);
        if (showTimeList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(showTimeList, HttpStatus.OK);
    }

    /**
     * @param
     * @return ShowTime
     * @content get showtime by id
     * @author PhatVN
     */
    @GetMapping("/public/showtime/showtime-by-id/{id}")
    public ResponseEntity<ShowTime> getShowTimeById(@PathVariable("id") Integer id) {
        ShowTime showTime = showTimeService.findShowTimeById(id);
        if (showTime == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(showTime, HttpStatus.OK);
    }

}