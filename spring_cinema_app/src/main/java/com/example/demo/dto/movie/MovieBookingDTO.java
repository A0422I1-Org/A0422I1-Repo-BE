package com.example.demo.dto.movie;

import java.util.Date;

public interface MovieBookingDTO {
    Integer getId();

    String getName();

    String getImage();

    Date getStartDay();

    Integer getTimeAmount();

    String getDescription();

    String getStatus();

    String getTrailer();

    String getLanguage();

    Boolean getIsDelete();
}
