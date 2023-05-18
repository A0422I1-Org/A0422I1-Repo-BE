package com.example.demo.service.movie;

import com.example.demo.dto.movie.IRatingMovieDTO;

public interface IRatingMovieService {
    /**
     * @param rating, username and movieId of movie
     * @return string
     * @content add new rating or change rating of movie by username
     * @author ChuongLN
     */
    String saveRating(Double rating, String username, Integer movieId);

    /**
     * @param movieId of movie
     * @return Double
     * @content get avg rating of movie
     * @author ChuongLN
     */
    Double getAvgRatingByMovieId(Integer movieId);

    /**
     * @param rating, username and movieId of movie
     * @return IRatingMovieDTO
     * @content Get Rating Movie By Username And MovieId
     * @author ChuongLN
     */
    public IRatingMovieDTO getRatingMovieByUsernameAndMovieId(String username, Integer movieId);
}
