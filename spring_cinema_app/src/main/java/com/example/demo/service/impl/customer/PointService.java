package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.repository.customer.IPointRepository;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService implements IPointService {
    @Autowired
    IPointRepository pointRepository;

    public List<Point> findAll(){
        return  pointRepository.findAll();
    }
}
