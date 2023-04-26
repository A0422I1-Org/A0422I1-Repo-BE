package com.example.demo.service.ticket;

import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IShowTimeService {
    List<ShowTime> findShowTimeByMovieId(Integer idMovie);
    ShowTime findShowTimeById( Integer id);
}
