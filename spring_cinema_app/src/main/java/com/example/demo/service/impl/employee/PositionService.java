package com.example.demo.service.impl.employee;

import com.example.demo.dto.employee.PositionViewDTO;
import com.example.demo.model.employee.Position;
import com.example.demo.repository.employee.IPositionRepository;
import com.example.demo.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public List<PositionViewDTO> convertAll(List<Position> positionList) {
        List<PositionViewDTO> dtoList=new ArrayList<>();
        for (Position position:positionList) {
            dtoList.add(new PositionViewDTO(position));
        }
        return dtoList;
    }
}

