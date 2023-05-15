package com.example.demo.repository.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.dto.movie.MovieBookingDTO;
import com.example.demo.model.dto.StatisticDTO.MovieDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import javax.transaction.Transactional;


@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    @Query(value = "select mv.id, mv.description, mv.image, mv.language, mv.name, mv.start_day as startDay, mv.time_amount as timeAmount, mv.trailer," +
            "GROUP_CONCAT(DISTINCT a.name SEPARATOR ', ') as actors, " +
            "GROUP_CONCAT(DISTINCT d.name SEPARATOR ', ') as directors, " +
            "GROUP_CONCAT(DISTINCT mtype.name SEPARATOR ', ') as movieTypes, " +
            "GROUP_CONCAT(DISTINCT mstudio.name SEPARATOR ', ') as movieStudios, " +
            "ROUND(AVG(rat.rating),1) as avgRating " +
            "from movie as mv " +
            "LEFT JOIN movie_actor ma ON mv.id = ma.movie_id " +
            "LEFT JOIN actor as a ON ma.actor_id = a.id " +
            "LEFT JOIN movie_director md ON mv.id = md.movie_id " +
            "LEFT JOIN director as d ON md.director_id = d.id " +
            "LEFT JOIN movie_and_type matype ON mv.id = matype.movie_id " +
            "LEFT JOIN movie_type as mtype ON matype.movie_type_id = mtype.id " +
            "LEFT JOIN movie_and_studio mastudio ON mv.id = mastudio.movie_id " +
            "LEFT JOIN movie_studio as mstudio ON mastudio.movie_studio_id = mstudio.id " +
            "LEFT JOIN rating_movie as rat ON mv.id = rat.movie_id where mv.id = ?1 and mv.is_delete = 0 " +
            "GROUP BY mv.id", nativeQuery = true)
    IMovieDetailDTO getMovieByMovieId(Integer movieId);

    List<Movie> findAllByIsDeleteFalseAndStatusEquals(String status);
    List<Movie> findAllByIsDeleteFalseAndNameContainingIgnoreCase(String name);
    /**
     * @return List<MovieBookingDTO>
     * @content find all the movies with showings
     * @author PhatVN
     */
    @Modifying
    @Query(value =
            "SELECT m.id, m.description, m.image, m.is_delete as isDelete , m.language, m.name, m.rating, m.start_day as startDay, m.status, m.time_amount as timeAmount, m.trailer " +
                    "FROM Movie as m " +
                    "JOIN show_time as st ON st.movie_id = m.id " +
                    "WHERE st.date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 2 DAY) " +
                    "AND (st.date > CURDATE() OR (st.start_time > TIME(NOW())))" +
                    "GROUP BY m.id", nativeQuery = true)
    List<MovieBookingDTO> findMoviesByStartDate();

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            " desc ",
            nativeQuery = true,
            countQuery = "select count(*) from  movie  join show_time  on show_time.movie_id = movie.id " +
                    "join ticket  on ticket.showtime_id = show_time.id " +
                    "where ticket.status = 1 " +
                    "group by movie.id " +
                    "order by count(movie.id)" +
                    " desc ")
    Page<MovieDTO> findStatisticMovieDesc(Pageable pageable);

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 " +
            "group by movie.id " +
            "order by count(movie.id)" +
            "asc ", nativeQuery = true,
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
            "desc ", nativeQuery = true,
            countQuery = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
                    "from movie  join show_time  on show_time.movie_id = movie.id " +
                    "join ticket  on ticket.showtime_id = show_time.id " +
                    "where ticket.status = 1 and movie.name like %?1% " +
                    "group by movie.id " +
                    "order by count(movie.id) " +
                    "desc ")
    Page<MovieDTO> searchStatisticMovieByNameDesc(String nameMovie, Pageable pageable);

    @Query(value = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
            "from movie  join show_time  on show_time.movie_id = movie.id " +
            "join ticket  on ticket.showtime_id = show_time.id " +
            "where ticket.status = 1 and movie.name like %?1% " +
            "group by movie.id " +
            "order by count(movie.id)  " +
            "asc ", nativeQuery = true,
            countQuery = "select movie.name as name , count(movie.id) as totalTicket, sum(ticket.price) as totalMoney " +
                    "from movie  join show_time  on show_time.movie_id = movie.id " +
                    "join ticket  on ticket.showtime_id = show_time.id " +
                    "where ticket.status = 1 and movie.name like %?1% " +
                    "group by movie.id " +
                    "order by count(movie.id) " +
                    "asc ")
    Page<MovieDTO> searchStatisticMovieByNameAsc(String nameMovie, Pageable pageable);

    @Query(value = "select * from Movie where " +
            "name like concat('%',:name,'%') " +
            "and start_day like concat('%',:startDay,'%') " +
            "and time_amount like concat('%',:timeAmount,'%') and is_delete = 0",
            nativeQuery = true)
    Page<Movie> findAllByNameAndByStartDayAndByTimeAmount(@Param("name") String name,
                                                          @Param("startDay") String startDay,
                                                          @Param("timeAmount") String timeAmount,
                                                          Pageable page);

    @Query(value = "select * from Movie where " +
            "name like concat('%',:name,'%') " +
            "and start_day like concat('%',:startDay,'%') " +
            "and time_amount like concat('%',:timeAmount,'%') and is_delete = 0",
            nativeQuery = true)
    List<Movie> findAllByThreeCondition(@Param("name") String name,
                                        @Param("startDay") String startDay,
                                        @Param("timeAmount") String timeAmount);

    @Modifying
    @Query("update Movie  m set m.isDelete = true where m.id = :id")
    Integer updateIsDeleteById(@Param("id") Integer id);
}















