package com.example.demo.service.movie;

public interface IMovieService {
    Iterable<?> findOnShowingMovie();
    Iterable<?> findUpcomingMovie();
    Iterable<?> findAll();
    Iterable<?> findMovieByName(String name);
}
