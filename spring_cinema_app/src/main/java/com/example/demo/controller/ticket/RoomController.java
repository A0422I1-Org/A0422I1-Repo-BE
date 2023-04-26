package com.example.demo.controller.ticket;


import com.example.demo.model.ticket.Room;
import com.example.demo.service.ticket.IChairRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    IChairRoomService chairRoomService;
    @GetMapping("/check-room/{idShowTime}")
    Room getRoomAvailable(@PathVariable("idShowTime") Integer id) {
        return chairRoomService.getRoomAvailable(id);
    }
}
