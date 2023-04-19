package com.example.demo.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer timeAmount;
    @NotNull
    private Date startDay;
    @NotNull
    private Integer movieStudioId;
    @NotNull
    private Boolean isDelete;

    @Transient
    public boolean isNew() {return id == null;}
}
