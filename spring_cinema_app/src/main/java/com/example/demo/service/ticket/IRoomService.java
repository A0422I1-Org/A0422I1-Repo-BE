package com.example.demo.service.ticket;

import com.example.demo.model.ticket.Room;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoomService {
    Room getRoomAvailable(int showTimeId);
}
