package com.example.demo.service.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IPointService {
    void save(Point point);
    List<Point> findAllPointByCustomer(Customer customer);
    Page<Point> findAllPointByCustomer(Customer customer , Pageable pageable);
    Page<Point> findAllPointDateBetweenByCustomer(String startDate, String endDate , String customerId ,Pageable  pageable);
//=======admmin

    List<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate , String customerId );
//>>>>>>> admin
}
