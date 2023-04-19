package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.repository.customer.IPointRepository;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PointService implements IPointService {
    @Autowired
    private IPointRepository iPointRepository;

    @Override
    public void save(Point point) {
        iPointRepository.save(point);
    }

    @Override
    public Page<Point> findAllPointByCustomer(Customer customer, Pageable pageable) {
        return iPointRepository.findPointByCustomers(customer.getId(), pageable);
    }

    @Override
    public Page<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate, String customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iPointRepository.findAllPointDateBetweenByCustomer(startDate, endDate, customerId, pageable);
    }
}
