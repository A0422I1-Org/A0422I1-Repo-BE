package com.example.demo.service.impl.ticket;

import com.example.demo.dto.ticket.ShowTimeBookingDTO;
import com.example.demo.model.ticket.ShowTime;
import com.example.demo.repository.ticket.IShowTimeRepository;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShowTimeService implements IShowTimeService {
    @Autowired
    IShowTimeRepository showTimeRepository;
    /**
     * @param
     * @return List<ShowTimeBookingDTO>
     * @content find all showtime by  idMovie
     * @author PhatVN
     */
    @Override
    public List<ShowTimeBookingDTO> findShowTimeByMovieId(Integer idMovie) {
        List<ShowTimeBookingDTO> showTimes = showTimeRepository.findShowTimeByMovieId(idMovie);
        if (showTimes == null || showTimes.isEmpty()) {
            return Collections.emptyList();
        }
        return showTimes;
    }
    /**
     * @param
     * @return List<ShowTimeBookingDTO>
     * @content find all showtime by  id
     * @author PhatVN
     */

    @Override
    public ShowTime findShowTimeById(Integer id) {
        return showTimeRepository.findShowTimeById(id);
    }


}