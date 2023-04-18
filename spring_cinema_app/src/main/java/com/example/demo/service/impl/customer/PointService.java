package com.example.demo.service.impl.customer;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
<<<<<<< HEAD
import com.example.demo.repository.customer.ICustomerRepository;
=======
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
import com.example.demo.repository.customer.IPointRepository;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
import java.util.List;

@Service
public class PointService implements IPointService {
    @Autowired
<<<<<<< HEAD
    IPointRepository pointRepository;

    public List<Point> findAll(){
        return  pointRepository.findAll();
=======
    private IPointRepository iPointRepository;

    @Override
    public void save(Point point) {
        iPointRepository.save(point);
    }


    @Override
    public List<Point> findAllPointByCustomer(Customer customer) {
        return iPointRepository.findPointByCustomers(customer.getId());
    }

    @Override
    public List<Point> findAllPointDateBetweenByCustomer(Date startDate, Date endDate , String customerId) {
        return iPointRepository.findAllPointDateBetweenByCustomer(startDate, endDate , customerId);
>>>>>>> 6ded61712d3661cd9f0804438362d7aa2ced7505
    }
}
