package com.example.demo.repository.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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

    @Modifying
    @Query(value =
            "SELECT m.id, m.description, m.image,m.is_delete,m.language,m.name,m.rating,m.start_day,m.status,m.time_amount,m.trailer " +
                    "FROM Movie m " +
                    "join show_time st on st.movie_id = m.id " +
                    "where st.date >= CURRENT_TIME  group by m.id ", nativeQuery = true)
    List<Movie> findMoviesByStartDate(LocalDate threeDaysLater);
}
