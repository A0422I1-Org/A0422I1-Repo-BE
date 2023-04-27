package com.example.demo.service.ticket;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITicketService {
    List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom,Integer idShowTime);
}
