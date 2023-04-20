package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.repository.customer.IPointRepository;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PointService implements IPointService {
    @Autowired
    private IPointRepository iPointRepository;

    @Override
    public void save(Point point) {
        iPointRepository.save(point);
    }


    @Override
    public List<Point> findAllPointByCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate , String customerId) {
        return iPointRepository.findAllPointDateBetweenByCustomer(startDate, endDate , customerId);
    }
}
