package com.example.demo.controller.account;

import com.example.demo.dto.ResetPassRequest;
import com.example.demo.dto.SignupRequest;
import com.example.demo.model.account.Account;
import com.example.demo.model.customer.Customer;
import com.example.demo.service.impl.account.AccountService;
import com.example.demo.service.impl.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    //    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<?> registerCustomer(@RequestBody SignupRequest signupRequest){
        if(accountService.existsByUserName(signupRequest.getUsername()) != null){
            return ResponseEntity.badRequest().body("Tên đăng nhập đã được đăng ký!");
        }
        Account account = new Account();
        account.setUsername(signupRequest.getUsername());
        account.setPassword(signupRequest.getPassword());
        account.setIsDelete(false);
        account.setIsEnable(false);
        accountService.save(account);
        Customer customer = new Customer(
                signupRequest.getFullName(),
                signupRequest.getGender(),
                signupRequest.getBirthday(),
                signupRequest.getEmail(),
                signupRequest.getPhoneNumber(),
                signupRequest.getAddress(),
                signupRequest.getPhoneNumber(),
                account,
                false
        );
        customerService.save(customer);
        return ResponseEntity.ok("Đăng ký tài khoản thành công!");
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        if(accountService.existsByPassword(resetPassRequest.getUsername(), resetPassRequest.getOldPassword()) != null){
            accountService.saveNewPassword(resetPassRequest.getPassword(), resetPassRequest.getUsername());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
