package com.example.demo.model.movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String image;
    @DateTimeFormat
    @Column(name = "start_day")
    private Date startDay;
    @NotNull
    @Column(name = "time_amount")
    private Integer timeAmount;
    @NotNull
    @Column(columnDefinition = ("text"))
    private String description;
    @NotNull
    private String status;
    @NotNull
    private String trailer;
    @NotNull
    private Double rating;
    @NotNull
    private String language;
    @NotNull
    private Boolean isDelete;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieAndStudio> getListStudio;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieActor> getListActor;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieAndType> getListType;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieDirector> getListDirector;
}
