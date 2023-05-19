package com.example.demo.controller.account;

import com.example.demo.dto.account.ResetPassRequest;
import com.example.demo.dto.account.SignupRequest;
import com.example.demo.model.account.Account;
import com.example.demo.model.account.AccountRole;
import com.example.demo.model.account.Role;
import com.example.demo.model.customer.Customer;
import com.example.demo.service.impl.account.AccountRoleService;
import com.example.demo.service.impl.account.AccountService;
import com.example.demo.service.impl.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountRoleService accountRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/public/signup")
    public ResponseEntity<?> registerCustomer(@RequestBody SignupRequest signupRequest){
        if(accountService.existsAccountByUsername(signupRequest.getUsername()) != null){
            return ResponseEntity.badRequest().body("Tên đăng nhập đã được đăng ký!");
        }
        Account account = new Account();
        account.setUsername(signupRequest.getUsername());
        account.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
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

        Role role = new Role(3, "CUSTOMER", false );
//        tạo contructor tại AccountRole
        AccountRole accountRole = new AccountRole(account, role, true);
        accountRoleService.addAccountRole(accountRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        if(accountService.existsByPassword(resetPassRequest.getUsername(), passwordEncoder.encode(resetPassRequest.getOldPassword())) != null){
            accountService.savePassword(resetPassRequest.getPassword(), resetPassRequest.getUsername());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return ResponseEntity.badRequest().body("Mật khẩu cũ không đúng!");
        }
    }
}
