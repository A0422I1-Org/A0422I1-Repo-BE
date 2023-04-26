package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.ShowTime;
import com.example.demo.repository.ticket.IShowTimeRepository;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ShowTimeService implements IShowTimeService {
    @Autowired
    IShowTimeRepository showTimeRepository;

    @Override
    public List<ShowTime> findShowTimeByMovieId(Integer idMovie) {
        LocalDate currentDate = LocalDate.now();
        List<ShowTime> showTimes = showTimeRepository.findShowTimeByMovieId(idMovie);
        if (showTimes == null || showTimes.isEmpty()) {
            return null;
        }
        return showTimes;
    }

    @Override
    public ShowTime findShowTimeById(Integer id) {
        return showTimeRepository.findShowTimeById(id);
    }


}
