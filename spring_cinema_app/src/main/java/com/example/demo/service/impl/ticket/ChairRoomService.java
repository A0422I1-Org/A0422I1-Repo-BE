package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.ChairRoom;
import com.example.demo.model.ticket.Room;
import com.example.demo.model.ticket.ShowTime;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.IChairRoomRepository;
import com.example.demo.repository.ticket.IRoomRepository;
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
        // Truy vấn bảng show_time để kiểm tra xem phòng hiện tại còn chỗ trống không
        ShowTime showTime = showTimeRepository.findShowTimeById(showTimeId);
        if (showTime == null || showTime.getSoldOut().equals('1')) {
            return false;
        }
        List<Ticket> ticketList = ticketRepository.findTicketAvailable(roomId,showTimeId);
        int countTicketInRoom = 0;
        for (Ticket ticket:ticketList) {
            if (ticket.getStatus()==true){
                countTicketInRoom++;
            }
        }
        if (countTicketInRoom == 40) {
            return false;
        }
        return true;
    }


}
