package com.example.demo.service.movie;

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
}
