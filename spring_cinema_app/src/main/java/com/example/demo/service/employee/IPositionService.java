package com.example.demo.service.employee;

import com.example.demo.dto.employee.PositionViewDTO;
import com.example.demo.model.employee.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    List<PositionViewDTO> convertAll(List<Position> positionList);
<<<<<<< HEAD
}
=======
}
>>>>>>> 0c38633d66e7a01ae60b5357fdbeb7a928d75984
