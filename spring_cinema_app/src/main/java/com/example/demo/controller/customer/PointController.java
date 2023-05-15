package com.example.demo.controller.customer;

import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.Point;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/user")
public class PointController {
    @Autowired
    private IPointService iPointService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IAccountService iAccountService;
    /**
     * @param price
     * @param descriptions
     * @return void
     * @Method : Save Point
     * @Author : TriLHH
     */
    @GetMapping("/save-point")
    public ResponseEntity<Void> savePoint(@RequestParam(name = "price", required = false, defaultValue = "0") int price, @RequestParam String descriptions, Principal principal) {
        Account account = iAccountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Date dateBookingTicket = new Date();
        int pointPlus = (int) (price * 0.02);
        Point point = new Point();
        point.setDate(dateBookingTicket);
        point.setDescription(descriptions);
        point.setPoint(pointPlus);
        point.setCustomers(customer);
        point.setIsDelete(false);
        iPointService.save(point);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * @param page
     * @return Point List
     * @Method : get all point by customer
     * @Author : TriLHH
     */
    @GetMapping("/point/{page}")
    public ResponseEntity<Page<Point>> getAllPointByCustomer(@PathVariable int page, Principal principal) {
        Account account = iAccountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Page<Point> pointList = iPointService.findAllPointByCustomer(customer, PageRequest.of(page, 5));
        if (pointList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(pointList, HttpStatus.OK);
    }
    /**
     * @return Integer
     * @Method : Sum Total Point
     * @Author : TriLHH
     */
    @GetMapping("/sum-point")
    public ResponseEntity<Integer> sumPoint(Principal principal) {
        Account account = iAccountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = iCustomerService.findCustomerByAccount(account);
        List<Point> pointList = iPointService.findAllPointByCustomer(customer);
        Integer totalPoint = 0;
        for (Point point : pointList
        ) {
            totalPoint += point.getPoint();
        }
        return new ResponseEntity<>(totalPoint, HttpStatus.OK);
    }
    /**
     * @param startDate
     * @param endDate
     * @param page
     * @param size
     * @return Point List
     * @Method : Search point by customer from date to date
     * @Author : TriLHH
     */
    @GetMapping("/search-point")
    public ResponseEntity<Page<Point>> getAllPointByDateBetween(@RequestParam("startDate") String startDate,
                                                                @RequestParam("endDate") String endDate,
                                                                @RequestParam int page, @RequestParam int size, Principal principal) {
        Account account = iAccountService.findByUsername(principal.getName()).orElse(null);
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(iPointService.findAllPointDateBetweenByCustomer(startDate, endDate, customer.getId(), pageable), HttpStatus.OK);
    }
}
