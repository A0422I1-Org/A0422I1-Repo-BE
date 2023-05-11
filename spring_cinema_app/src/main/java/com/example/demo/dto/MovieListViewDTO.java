package com.example.demo.dto;

import com.example.demo.model.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieListViewDTO {
    private Integer id;
    private String name;
    private String image;
    private Integer timeAmount;
    private Date startDay;
    private String status;
    private Boolean isDelete;
    private String movieType;
    public MovieListViewDTO(Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.image = movie.getImage();
        this.timeAmount = movie.getTimeAmount();
        this.startDay = movie.getStartDay();
        this.status = movie.getStatus();
        this.movieType = movie.getGetListMovieType()
                .stream()
                .map(item -> item.getMovieType().getName())
                .collect(Collectors.joining(", "));
        this.isDelete = movie.getIsDelete();
    }
}
