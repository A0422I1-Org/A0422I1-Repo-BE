package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.ChairRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IChairRoomRepository extends JpaRepository<ChairRoom, Integer> {
    @Modifying
    @Query(value =
            "SELECT cr.id,cr.is_delete,cr.status,cr.chair_id, cr.room_id" +
                    "FROM chair_room cr" +
                    "WHERE cr.room_id = :idRoom"
            , nativeQuery = true)
    List<ChairRoom> findByIdRom(@Param("idRoom") Integer idRoom);

}