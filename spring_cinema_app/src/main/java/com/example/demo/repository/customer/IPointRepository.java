package com.example.demo.repository.customer;

import com.example.demo.model.customer.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPointRepository extends JpaRepository<Point, Integer> {
}
