package com.example.demo.controller.ticket;


import com.example.demo.model.ticket.Room;
import com.example.demo.service.ticket.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/public/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    IRoomService roomService;

    /**
     * @param
     * @return Room
     * @content get room of showtime now
     * @author PhatVN
     */
    @GetMapping("/check-room/{idShowTime}")
    public ResponseEntity<Room> getRoomAvailable(@PathVariable("idShowTime") Integer id) {
        Room room = roomService.getRoomAvailable(id);
        if (room ==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
