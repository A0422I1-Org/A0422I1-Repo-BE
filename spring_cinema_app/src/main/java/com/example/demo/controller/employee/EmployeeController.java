package com.example.demo.controller.employee;

import com.example.demo.dto.employee.EmployeeCreateDTO;
import com.example.demo.dto.employee.EmployeeDTO;
import com.example.demo.dto.employee.EmployeeUpdateDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.account.AccountRole;
import com.example.demo.model.account.Role;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import com.example.demo.service.account.IAccountRoleService;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IAccountRoleService accountRoleService;

    @PostMapping("/add")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeCreateDTO employee) {
        if(accountService.existsByEmployeeName(employee.getUsername()) != null){
            return ResponseEntity.badRequest().body("Account đã tồn tại!");
        }
        Account account = new Account();
        account.setUsername(employee.getUsername());
        account.setPassword(employee.getPassword());
        account.setIsEnable(false);
        account.setIsDelete(false);
        accountService.addNewAccount(account);
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        Role role = new Role(2,"employee",false);
        accountRole.setRole(role);
        accountRole.setIsDelete(false);
        accountRoleService.addAccountRole(accountRole);
        Employee employee1 = new Employee(
                employee.getFullName(),
                employee.getImage(),
                employee.getGender(),
                employee.getBirthday(),
                employee.getEmail(),
                false,
                employee.getPhoneNumber(),
                employee.getAddress(),
                employee.getCardId(),
                employee.getPosition(),
                account,
                false
        );
        employee1.setId("id0012");
        return new ResponseEntity<>(employeeService.addNewEmployee(employee1), HttpStatus.CREATED);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Employee> findCustomerById(@PathVariable String id) {
        Optional<Employee> customerOptional = employeeService.findEmployeeById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("00000000000000000000000000000000000000000000");
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee){
        System.out.println("@222222222222222222222222222222222222222222222222222");
        employeeService.updateEmployee(employee);
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        accountService.updatePass(employee);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> findAccountId(@PathVariable String id) {
        Optional<Account> accountOptional = accountService.findAccountByUsername(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountOptional.get(), HttpStatus.OK);
    }
//    @PutMapping("/id")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee){
//        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
//        if (!employeeOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        Optional<Account> accountOptional = accountService.findAccountByUsername(String.valueOf(employeeOptional.get().getAccount()));
//        accountService.updatePass(employee);
//        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
//    }

}
