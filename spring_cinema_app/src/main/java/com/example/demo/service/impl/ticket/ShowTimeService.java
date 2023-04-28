package com.example.demo.service.impl.ticket;

import com.example.demo.repository.ticket.IShowTimeRepository;
import com.example.demo.service.ticket.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShowTimeService implements IShowTimeService {
    @Autowired
    IShowTimeRepository showTimeRepository;

    /**
     * Get all showtime movie by ticket
     *
     * no @param
     * @return List<Map<String,Object>>
     *
     * @Author: NghiaDC
     */
    @Override
    public List<Map<String, Object>> statisticShowtime() {
        return showTimeRepository.statisticShowtime();
    }
}
