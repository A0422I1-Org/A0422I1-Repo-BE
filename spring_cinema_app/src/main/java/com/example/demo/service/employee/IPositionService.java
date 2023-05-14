package com.example.demo.service.employee;

import com.example.demo.dto.employee.PositionViewDTO;
import com.example.demo.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    List<PositionViewDTO> convertAll(List<Position> positionList);
}
