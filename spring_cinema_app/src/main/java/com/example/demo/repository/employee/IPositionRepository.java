package com.example.demo.repository.employee;

import com.example.demo.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
    @Query("SELECT p FROM Position p WHERE p.isDelete=false")
    List<Position> findAll();
}

