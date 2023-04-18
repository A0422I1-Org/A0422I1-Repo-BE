package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;

import java.util.Date;
import java.util.List;

public interface IPointService {
    void save(Point point);

    List<Point> findAllPointByCustomer(Customer customer);

    List<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate , String customerId );
}
