package com.example.demo.dto.ticket;

import com.example.demo.model.movie.Movie;

import java.util.Date;

public interface ShowTimeBookingDTO {
     Integer getId();
     Date getDate();
     String getStartTime();
     String getEndTime();
     String getSoldOut();
     Integer getMovieId();
     Boolean getDelete();

}
