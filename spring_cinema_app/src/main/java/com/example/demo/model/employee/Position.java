package com.example.demo.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = ("varchar(255)"))
    private String name;
    @NotNull
    private Boolean isDelete;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private Set<Employee> employeeSet;

    public Position() {
    }


    public Position(Integer id, String name, Boolean isDelete, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.employeeSet = employeeSet;
    }
}
