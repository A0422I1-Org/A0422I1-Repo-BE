package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService  implements ITicketService {
    @Autowired
    ITicketRepository ticketRepository;

    @Override
    public List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom, Integer idShowTime) {
        return ticketRepository.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
    }

}
