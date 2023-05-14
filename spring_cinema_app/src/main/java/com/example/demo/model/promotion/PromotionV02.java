package com.example.demo.model.promotion;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Entity
public class PromotionV02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String title;

    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String image;

    @NotNull
    @Column(columnDefinition = ("text"))
    private String description;

    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String name;

    @Column(columnDefinition = ("varchar(255)"))
    private String time;

    @NotNull
    @Column(columnDefinition = ("text"))
    private String content;

    @NotNull
    @Column(columnDefinition = ("varchar(255)"))
    private String location;

    @NotNull
    @Column(columnDefinition = ("text"), name = "condition_promotion")
    private String conditionPromotion;

    private Boolean isDelete;

    public PromotionV02() {
    }

    public PromotionV02(String title, String image, String description, String name, String time, String content, String location, String conditionPromotion, Boolean isDelete) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.name = name;
        this.time = time;
        this.content = content;
        this.location = location;
        this.conditionPromotion = conditionPromotion;
        this.isDelete = isDelete;
    }
}
