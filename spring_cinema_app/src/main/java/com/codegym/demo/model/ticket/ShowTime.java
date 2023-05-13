package com.codegym.demo.model.ticket;

import com.codegym.demo.model.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat
    @NotNull
    private Date date;
    @NotNull
    private String startTime;
    private String endTime;
    @NotNull
    private Boolean soldOut;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    private Boolean isDelete;




}
