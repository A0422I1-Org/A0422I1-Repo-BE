package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IPointService {
    void save(Point point);

    Page<Point> findAllPointByCustomer(Customer customer , Pageable pageable);

    Page<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate , String customerId , int page , int size );
}
