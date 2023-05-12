package com.example.demo.service.ticket;

import org.springframework.stereotype.Service;

@Service
public interface IChairRoomService {
    boolean checkAvailableChairRoom(int roomId, int showTimeId);
}