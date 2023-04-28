package com.example.demo.repository.movie;

import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            " desc ",
            nativeQuery = true ,
            countQuery = "select count(*) from  movie  join show_time  on show_time.movie_id = movie.id "+
                    "join ticket  on ticket.showtime_id = show_time.id " +
                    "where ticket.status = 1 "+
                    "group by movie.id " +
                    "order by count(movie.id)"+
                    " desc ")
    Page<MovieDTO> findStatisticMovieDesc(Pageable pageable);

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 " +
            "group by movie.id " +
            "order by count(movie.id)" +
            "asc ", nativeQuery = true ,
    countQuery = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
          "from movie  join show_time  on show_time.movie_id = movie.id " +
          "join ticket  on ticket.showtime_id = show_time.id " +
           "where ticket.status = 1 " +
           "group by movie.id " +
           "order by count(movie.id) " +
           "asc ")
    Page<MovieDTO> findStatisticMovieAcs(Pageable pageable);

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 and movie.name like %?1% " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            "desc ", nativeQuery = true ,
            countQuery = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
                   "from movie  join show_time  on show_time.movie_id = movie.id " +
                   "join ticket  on ticket.showtime_id = show_time.id " +
                   "where ticket.status = 1 and movie.name like %?1% " +
                   "group by movie.id " +
                   "order by count(movie.id) " +
                   "desc ")
    Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie , Pageable pageable);

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 and movie.name like %?1% " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            "asc ", nativeQuery = true ,
            countQuery = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
                    "from movie  join show_time  on show_time.movie_id = movie.id " +
                    "join ticket  on ticket.showtime_id = show_time.id " +
                    "where ticket.status = 1 and movie.name like %?1% " +
                    "group by movie.id " +
                    "order by count(movie.id) " +
                    "asc ")
    Page<MovieDTO> searchStatisticMovieByNameAsc(String nameMovie , Pageable pageable);

}
