package com.example.demo.repository.customer;

import com.example.demo.model.customer.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPointRepository extends JpaRepository<Point, Integer> {
    @Query(nativeQuery = true, value = "select * from point where customer_id = ? ")
    List<Point> findPointByCustomers(String customer);
}
