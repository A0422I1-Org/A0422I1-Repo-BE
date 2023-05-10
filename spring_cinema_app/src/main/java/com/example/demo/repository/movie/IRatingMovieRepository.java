package com.example.demo.repository.movie;

import com.example.demo.dto.movie.IRatingMovieDTO;
import com.example.demo.model.movie.RatingMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IRatingMovieRepository extends JpaRepository<RatingMovie, Integer> {

    /**
     * @param username and movieId of movie
     * @return IRatingMovieDTO
     * @content get rating by username
     * @author ChuongLN
     */
    @Query(value = "select r.id, r.rating, r.username, r.movie_id as movieId from rating_movie as r where r.username = ?1 and r.movie_id =?2", nativeQuery = true)
    IRatingMovieDTO getRatingMovieByUsernameAndMovieId(String username, Integer movieId);

    /**
     * @param movieId of movie
     * @return Double
     * @content get avg rating of movie
     * @author ChuongLN
     */
    @Query(value = "select ROUND(AVG(rating),1) as avgRating from rating_movie where movie_id = ?1", nativeQuery = true)
    Double getAvgRatingByMovieId(Integer movieId);

    /**
     * @param rating, username, movieId of movie and isDelete
     * @return void
     * @content add new rating of movie by username
     * @author ChuongLN
     */
    @Modifying
    @Query(value = "insert into rating_movie (rating, username, movie_id, is_delete) values (?1 , ?2, ?3, ?4)", nativeQuery = true)
    void addRating(Double rating, String username, Integer movieId, Boolean isDelete);

    /**
     * @param rating and ratingId of rating
     * @return void
     * @content update rating of movie by username
     * @author ChuongLN
     */
    @Modifying
    @Query(value = "update rating_movie set rating =?1 where id =?2", nativeQuery = true)
    void updateRating(Double rating, Integer ratingId);

}
