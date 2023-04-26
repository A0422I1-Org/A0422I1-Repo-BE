package com.example.demo.service.ticket;

import com.example.demo.model.ticket.Room;
import org.springframework.stereotype.Service;

@Service
public interface IChairRoomService {
    Room getRoomAvailable(int showTimeId);
}
