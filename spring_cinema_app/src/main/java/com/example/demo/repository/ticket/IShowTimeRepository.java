package com.example.demo.repository.ticket;

import com.example.demo.model.ticket.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShowTimeRepository extends JpaRepository<ShowTime,Integer> {
//    @Query("select ShowTime from ShowTime where ShowTime.movie.id =: idMovie")
     List<ShowTime> findShowTimeByMovieId(Integer id);
}
