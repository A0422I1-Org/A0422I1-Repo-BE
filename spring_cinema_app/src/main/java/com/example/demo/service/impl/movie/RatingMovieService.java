package com.example.demo.service.impl.movie;

import com.example.demo.dto.movie.IRatingMovieDTO;
import com.example.demo.repository.movie.IRatingMovieRepository;
import com.example.demo.service.movie.IRatingMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingMovieService implements IRatingMovieService {
    @Autowired
    private IRatingMovieRepository ratingMovieRepository;

    /**
     * @param rating, username and movieId of movie
     * @return string
     * @content add new rating or change rating of movie by username
     * @author ChuongLN
     */
    @Override
    public String saveRating(Double rating, String username, Integer movieId) {
        IRatingMovieDTO existingRatingMovie = ratingMovieRepository.getRatingMovieByUsernameAndMovieId(username, movieId);
        if (existingRatingMovie != null) {
            ratingMovieRepository.updateRating(rating, existingRatingMovie.getId());
            return "Bạn đã thay đổi đánh giá phim thành công";
        } else {
            ratingMovieRepository.addRating(rating, username, movieId, false);
            return "Bạn đã đánh giá phim thành công";
        }
    }

    /**
     * @param movieId of movie
     * @return Double
     * @content get avg rating of movie
     * @author ChuongLN
     */
    public Double getAvgRatingByMovieId(Integer movieId){
        return ratingMovieRepository.getAvgRatingByMovieId(movieId);
    }
}
