package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.ShowTime;
import com.example.demo.repository.ticket.IShowTimeRepository;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeService implements IShowTimeService {
    @Autowired
    IShowTimeRepository showTimeRepository;
    @Override
    public List<ShowTime> findShowTimeByMovieId(Integer idMovie) {
        return showTimeRepository.findShowTimeByMovieId(idMovie);
    }
}
