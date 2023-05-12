package com.example.demo.service.ticket;

import com.example.demo.dto.ticket.ShowTimeBookingDTO;
import com.example.demo.model.ticket.ShowTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IShowTimeService {
    List<ShowTimeBookingDTO> findShowTimeByMovieId(Integer idMovie);
    ShowTime findShowTimeById( Integer id);
}
