package com.example.demo.service.impl.ticket;

import com.example.demo.model.ticket.Room;
import com.example.demo.repository.ticket.IRoomRepository;
import com.example.demo.service.ticket.IChairRoomService;
import com.example.demo.service.ticket.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;
    @Autowired
    IChairRoomService chairRoomService;
    @Override
    public Room getRoomAvailable(int showTimeId) {
        List<Room> roms = roomRepository.getRoomByShowTimeOfMovie(showTimeId);
        for (Room room: roms) {
            if (chairRoomService.checkAvailableChairRoom(room.getId(),showTimeId)){
                return room;
            }
        }
        return null;
    }
}
