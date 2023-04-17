package com.example.demo.controller;

import com.example.demo.model.employee.Position;
import com.example.demo.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<Iterable<Position>> findAllPosition() {
        List<Position> positions = (List<Position>) positionService.finAll();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

}
