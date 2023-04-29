package com.example.demo.service.impl.ticket;


import com.example.demo.model.ticket.ShowTime;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.IChairRoomRepository;
import com.example.demo.repository.ticket.IShowTimeRepository;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.IChairRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairRoomService implements IChairRoomService {
    @Autowired
    IShowTimeRepository showTimeRepository;
    @Autowired
    IChairRoomRepository chairRoomRepository;
    @Autowired
    ITicketRepository ticketRepository;

    @Override
    public boolean checkAvailableChairRoom(int roomId, int showTimeId) {
        ShowTime showTime = showTimeRepository.findShowTimeById(showTimeId);
        if (showTime == null) {
            return false;
        }
        List<Ticket> ticketList = ticketRepository.findTicketAvailable(roomId, showTimeId);
        int countTicketInRoom = 0;
        for (Ticket ticket : ticketList) {
            if (ticket.getStatus()) {
                countTicketInRoom++;
            }
        }
        return countTicketInRoom != 40;
    }


}
