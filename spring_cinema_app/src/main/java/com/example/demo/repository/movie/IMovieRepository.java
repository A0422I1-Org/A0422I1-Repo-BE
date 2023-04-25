package com.example.demo.repository.movie;

import com.example.demo.dto.movie.IMovieDetailDTO;
import com.example.demo.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    /**
     * @param movieId of movie
     * @return IMovieDetailDTO
     * @content get movie detail by movieId
     * @author ChuongLN
     */
    @Query(value = "select mv.id, mv.description, mv.image, mv.is_delete as `delete`, mv.language, mv.name, mv.rating, mv.start_day as startDay, mv.time_amount as timeAmount, mv.trailer," +
            "GROUP_CONCAT(DISTINCT a.name SEPARATOR ', ') as actors, " +
            "GROUP_CONCAT(DISTINCT d.name SEPARATOR ', ') as directors, " +
            "GROUP_CONCAT(DISTINCT mtype.name SEPARATOR ', ') as movieTypes, " +
            "GROUP_CONCAT(DISTINCT mstudio.name SEPARATOR ', ') as movieStudios from movie as mv " +
            "LEFT JOIN movie_actor ma ON mv.id = ma.movie_id " +
            "LEFT JOIN actor as a ON ma.actor_id = a.id " +
            "LEFT JOIN movie_director md ON mv.id = md.movie_id " +
            "LEFT JOIN director as d ON md.director_id = d.id " +
            "LEFT JOIN movie_and_type matype ON mv.id = matype.movie_id " +
            "LEFT JOIN movie_type as mtype ON matype.movie_type_id = mtype.id " +
            "LEFT JOIN movie_and_studio mastudio ON mv.id = mastudio.movie_id " +
            "LEFT JOIN movie_studio as mstudio ON mastudio.movie_studio_id = mstudio.id  where mv.id = ?1 " +
            "GROUP BY mv.id", nativeQuery = true)
    IMovieDetailDTO getMovieByMovieId(Integer movieId);
}
