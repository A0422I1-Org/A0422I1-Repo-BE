package com.example.demo.dto.employee;

import com.example.demo.model.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PositionViewDTO {
    private Integer id;
    private String name;

    public PositionViewDTO() {
    }

    public PositionViewDTO(Position position) {
        this.id = position.getId();
        this.name = position.getName();
    }
}
