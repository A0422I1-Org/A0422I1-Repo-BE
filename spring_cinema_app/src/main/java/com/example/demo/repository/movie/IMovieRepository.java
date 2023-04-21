package com.example.demo.repository.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            "desc limit ?1,5;", nativeQuery = true)
    List<MovieDTO> findStatisticMovie(int index);

    @Query("select new map(m.name as name , count(m.id) as totalTicket, sum(t.price) as totalMoney) from Movie m join ShowTime s on s.movie.id = m.id join Ticket t on t.showTime.id = s.id where t.status = true group by m.id order by count(m.id)  asc ")
    List<?> findStatisticMovieAcs();

    @Query("select new map(m.name as name , count(m.id) as totalTicket, sum(t.price) as totalMoney) from Movie m join ShowTime s on s.movie.id = m.id join Ticket t on t.showTime.id = s.id where t.status = true and m.name like  %?1% group by m.id order by count(m.id) desc ")
    List<?> searchStatisticMovieByName(String nameMovie);

}
