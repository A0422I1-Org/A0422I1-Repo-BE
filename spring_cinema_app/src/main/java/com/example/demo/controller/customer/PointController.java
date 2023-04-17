package com.example.demo.controller.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.repository.account.IAccountRepository;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private IAccountRepository accountRepository;

    @PostMapping("/savePoint")
    public ResponseEntity<?> savePoint(@RequestParam int price, @RequestParam String description) {
        Account account = accountRepository.findByUsername("KH-001");
        Date dateBookingTicket = new Date();
        int pointPlus = (int) (price * 0.02);
        Point point = new Point();
        point.setDate(dateBookingTicket);
        point.setDescription("Được cộng điểm do đặt vé xem phim : " + description);
        point.setPoint(pointPlus);
        point.setCustomers(iCustomerService.findById(iCustomerService.findCustomerByAccount(account).getId()));
        point.setIsDelete(false);
        iPointService.save(point);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer-point/{customerId}")
    public ResponseEntity<List<Point>> getAllPointByCustomer(@PathVariable String customerId) {
        Customer customer = iCustomerService.findById(customerId);
        List<Point> pointList = iPointService.findAllPointByCustomer(customer);
        return new ResponseEntity<>(pointList, HttpStatus.OK);
    }




}
