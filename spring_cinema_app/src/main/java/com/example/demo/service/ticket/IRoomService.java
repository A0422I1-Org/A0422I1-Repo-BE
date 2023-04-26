package com.example.demo.service.ticket;

import com.example.demo.model.ticket.Room;

public interface IRoomService {
    Room getRoomAvailable(int showTimeId);
}
