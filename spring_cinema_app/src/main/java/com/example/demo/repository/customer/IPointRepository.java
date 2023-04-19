package com.example.demo.repository.customer;

import com.example.demo.model.customer.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IPointRepository extends JpaRepository<Point, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM point WHERE (date BETWEEN ?1  AND  ?2 ) and (is_delete = false) and (customer_id = ?3)")
    Page<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate, String customerId, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from point WHERE customer_id = ? and is_delete = false")
    Page<Point> findPointByCustomers(String customer, Pageable pageable);


    @Query(nativeQuery = true, value = "INSERT INTO point ( date, description, is_delete, point, customer_id) VALUES (?, ?, ? , ? , ?);")
    void savePoint(Date date, String description, Boolean is_delete, Integer point, String customer_id);


//    List<Point> findByDateBetween(Date startDate  , Date endDate);
}
