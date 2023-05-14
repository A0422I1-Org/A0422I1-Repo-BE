package com.example.demo.dto.movie;

public class RatingMovieDTO implements IRatingMovieDTO{
    private Integer id;
    private String username;
    private double rating;
    private Integer movieId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Double getRating() {
        return rating;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Integer getMovieId() {
        return movieId;
    }
}
