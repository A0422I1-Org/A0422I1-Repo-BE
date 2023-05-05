package com.example.demo.controller.employee;

import com.example.demo.dto.employee.PositionViewDTO;
import com.example.demo.model.employee.Position;
import com.example.demo.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
=======
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
>>>>>>> 0c38633d66e7a01ae60b5357fdbeb7a928d75984
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping("/position")
    public ResponseEntity<Iterable<PositionViewDTO>> findAllPosition() {
        List<Position> positions = (List<Position>) positionService.findAll();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positionService.convertAll(positions), HttpStatus.OK);
    }
<<<<<<< HEAD
=======

>>>>>>> 0c38633d66e7a01ae60b5357fdbeb7a928d75984
}
