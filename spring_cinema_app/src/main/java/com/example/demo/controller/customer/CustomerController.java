package com.example.demo.controller.customer;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.customer.Customer;
import com.example.demo.service.impl.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HttpSession session;

    @GetMapping("/{username}")
    public ResponseEntity<Customer> findCustomerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(this.customerService.findCustomerByUsername(username), HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> updateTaiKhoan(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getFullName(),
                customerDTO.getGender(),
                customerDTO.getBirthday(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber(),
                customerDTO.getAddress(),
                customerDTO.getCardId()
        );
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}