package com.example.demo.repository.movie;

import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select new map(m.name as name , count(m.id) as totalTicket, sum(t.price) as totalMoney) from Movie m join ShowTime s on s.movie.id = m.id join Ticket t on t.showTime.id = s.id where t.status = true group by m.id order by count(m.id)  desc")
    List<?> findStatisticMovie();

}
