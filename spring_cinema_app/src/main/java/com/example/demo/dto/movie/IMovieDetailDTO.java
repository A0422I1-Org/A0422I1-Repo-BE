package com.example.demo.dto.movie;

import java.util.Date;

public interface IMovieDetailDTO {
    Integer getId();

    String getName();

    String getImage();

    Date getStartDay();

    Integer getTimeAmount();

    String getDescription();

    String getTrailer();

    String getLanguage();

    String getActors();

    String getDirectors();

    String getMovieTypes();

    String getMovieStudios();

    Double getAvgRating();
}
