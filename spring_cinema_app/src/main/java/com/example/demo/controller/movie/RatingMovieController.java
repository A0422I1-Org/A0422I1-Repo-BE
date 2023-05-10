package com.example.demo.controller.movie;

import com.example.demo.dto.movie.RatingMovieDTO;
import com.example.demo.service.movie.IRatingMovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/public/rating")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingMovieController {
    @Autowired
    private IRatingMovieService ratingMovieService;

    /**
     * @param ratingMovieDTO
     * @return string
     * @content add new rating or change rating of movie by username
     * @author ChuongLN
     */
    @PostMapping("add")
    public ResponseEntity<String> saveRating(@RequestBody RatingMovieDTO ratingMovieDTO) {
        String message = ratingMovieService.saveRating(ratingMovieDTO.getRating(), ratingMovieDTO.getUsername(), ratingMovieDTO.getMovieId());
        Double avgRating = ratingMovieService.getAvgRatingByMovieId(ratingMovieDTO.getMovieId());
        Map<String, String> result = new HashMap<>();
        result.put("messageTemp", message);
        result.put("avgRatingTemp", avgRating.toString());
        String jsonResult = " ";
        try {
            jsonResult = new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e){
        }
        return new ResponseEntity<>(jsonResult, HttpStatus.OK);
    }
}
