package com.codegym.demo.service.impl.customer;

import com.codegym.demo.model.customer.Point;
import com.codegym.demo.repository.customer.IPointRepository;
import com.codegym.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService implements IPointService {
    @Autowired
    private IPointRepository iPointRepository;

    @Override
    public void save(Point point) {
        iPointRepository.save(point);
    }
}
