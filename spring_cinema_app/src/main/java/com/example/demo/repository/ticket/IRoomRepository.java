package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<Room,Integer> {
    
}
