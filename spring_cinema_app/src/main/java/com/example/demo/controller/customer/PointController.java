package com.example.demo.controller.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/customer")
public class PointController {
    @Autowired
    private IPointService iPointService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IAccountService iAccountService;

    @PostMapping("/savePoint")
    public ResponseEntity<?> savePoint(@RequestParam int price, @RequestParam String description) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Date dateBookingTicket = new Date();
        int pointPlus = (int) (price * 0.02);
        Point point = new Point();
        point.setDate(dateBookingTicket);
        point.setDescription("Được cộng điểm do đặt vé xem phim : " + description);
        point.setPoint(pointPlus);
        point.setCustomers(customer);
        point.setIsDelete(false);
        iPointService.save(point);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer-point")
    public ResponseEntity<List<Point>> getAllPointByCustomer() {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        List<Point> pointList = iPointService.findAllPointByCustomer(customer);
        if (pointList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(pointList, HttpStatus.OK);
    }

    @GetMapping("/customer-search-point")
    public ResponseEntity<List<Point>> getAllPointByDateBetween(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        return new ResponseEntity<>(iPointService.findAllPointDateBetweenByCustomer(startDate, endDate, customer.getId()), HttpStatus.OK);
    }
}