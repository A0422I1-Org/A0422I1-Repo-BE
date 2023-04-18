package com.example.demo.repository.customer;

import com.example.demo.model.customer.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPointRepository extends JpaRepository<Point, Integer> {
    @Query(nativeQuery = true, value = "SELECT  id, date, description, is_delete, point, customer_id FROM point WHERE (date BETWEEN ?1 AND ?2) and (is_delete = false) and (customer_id = ?3)")
    List<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate, String customerId);

    @Query(nativeQuery = true, value = "select * from point where customer_id = ? and (is_delete = false)")
    List<Point> findPointByCustomers(String customer);

//    List<Point> findByDateBetween(Date startDate  , Date endDate);
}
