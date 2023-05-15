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

//    public Movie() {
//    }
//
//    public Movie(Integer id, @NotNull String name, @NotNull String image, Date startDay, @NotNull Integer timeAmount, @NotNull String description, @NotNull String status, @NotNull String trailer, @NotNull Double rating, @NotNull String language, @NotNull Boolean isDelete, List<MovieAndStudio> getListStudio, List<MovieActor> getListActor, List<MovieAndType> getListType, List<MovieDirector> getListDirector) {
//        this.id = id;
//        this.name = name;
//        this.image = image;
//        this.startDay = startDay;
//        this.timeAmount = timeAmount;
//        this.description = description;
//        this.status = status;
//        this.trailer = trailer;
//        this.rating = rating;
//        this.language = language;
//        this.isDelete = isDelete;
//        this.getListStudio = getListStudio;
//        this.getListActor = getListActor;
//        this.getListType = getListType;
//        this.getListDirector = getListDirector;
//    }


//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Date getStartDay() {
//        return startDay;
//    }
//
//    public void setStartDay(Date startDay) {
//        this.startDay = startDay;
//    }
//
//    public Integer getTimeAmount() {
//        return timeAmount;
//    }
//
//    public void setTimeAmount(Integer timeAmount) {
//        this.timeAmount = timeAmount;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getTrailer() {
//        return trailer;
//    }
//
//    public void setTrailer(String trailer) {
//        this.trailer = trailer;
//    }
//
//    public Double getRating() {
//        return rating;
//    }
//
//    public void setRating(Double rating) {
//        this.rating = rating;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public Boolean getDelete() {
//        return isDelete;
//    }
//
//    public void setDelete(Boolean delete) {
//        isDelete = delete;
//    }
//
//    public List<MovieAndStudio> getGetListStudio() {
//        return getListStudio;
//    }
//
//    public void setGetListStudio(List<MovieAndStudio> getListStudio) {
//        this.getListStudio = getListStudio;
//    }
//
//    public List<MovieActor> getGetListActor() {
//        return getListActor;
//    }
//
//    public void setGetListActor(List<MovieActor> getListActor) {
//        this.getListActor = getListActor;
//    }
//
//    public List<MovieAndType> getGetListType() {
//        return getListType;
//    }
//
//    public void setGetListType(List<MovieAndType> getListType) {
//        this.getListType = getListType;
//    }
//
//    public List<MovieDirector> getGetListDirector() {
//        return getListDirector;
//    }
//
//    public void setGetListDirector(List<MovieDirector> getListDirector) {
//        this.getListDirector = getListDirector;
//    }
}
