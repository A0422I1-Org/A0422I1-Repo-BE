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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    /**
     * @param price
     * @param descriptions
     * @return void
     * @Method : Save Point
     * @Author : TriLHH
     */
    @PostMapping("/savePoint")
    public ResponseEntity<?> savePoint(@RequestParam int price, @RequestParam String descriptions) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Date dateBookingTicket = new Date();
        int pointPlus = (int) (price * 0.02);
        String description = "do xem phim : " + descriptions;
        Point point = new Point();
        point.setDate(dateBookingTicket);
        point.setDescription(description);
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

    @GetMapping("/customer-point/{page}")
    public ResponseEntity<Page<Point>> getAllPointByCustomer(@PathVariable int page) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        Page<Point> pointList = iPointService.findAllPointByCustomer(customer, PageRequest.of(page, 5));
        if (pointList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(pointList, HttpStatus.OK);
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

    @GetMapping("/customer-search-point")
    public ResponseEntity<Page<Point>> getAllPointByDateBetween(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                                @RequestParam int page, @RequestParam int size) {
        Account account = iAccountService.findByUsername("customer4");
        Customer customer = iCustomerService.findCustomerByAccount(account);
        if (startDate.after(endDate) || startDate.equals(endDate)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(iPointService.findAllPointDateBetweenByCustomer(startDate, endDate, customer.getId(), page, size), HttpStatus.OK);
    }
}