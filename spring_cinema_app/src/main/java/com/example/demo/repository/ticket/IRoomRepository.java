package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IRoomRepository extends JpaRepository<Room,Integer> {
    @Modifying
    @Query(value =
            "select r.id,r.name,r.is_delete,r.screen  from room r " +
                    "join chair_room cr on r.id = cr.room_id " +
                    "join ticket t on t.chair_room_id = cr.id " +
                    "where t.showtime_id = :idShowTime"
            , nativeQuery = true)
    List<Room> getRoomByShowTimeOfMovie(@Param("idShowTime") int idShowTime);

}
