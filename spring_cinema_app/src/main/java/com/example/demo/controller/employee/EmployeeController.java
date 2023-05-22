package com.example.demo.controller.employee;

import com.example.demo.dto.employee.EmployeeCreateDTO;
import com.example.demo.dto.employee.EmployeeDeleteDTO;
import com.example.demo.dto.employee.EmployeeViewDTO;
import com.example.demo.error.NotFoundById;
import com.example.demo.model.account.Account;
import com.example.demo.model.account.AccountRole;
import com.example.demo.model.account.Role;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.example.demo.service.account.IAccountRoleService;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.impl.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmployeeController {
//    private static int counter = 5;
    private static final String PATTERN = "NV";
    private static final int MAXDISPLAY = 5;

    public static String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ssSSS");
        String dateString = dateFormat.format(new Date());
        String id = String.format(PATTERN);
        return id + "-" + dateString;
    }
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IAccountRoleService accountRoleService;

    @GetMapping("/employee")
    public ResponseEntity<Page<EmployeeViewDTO>> getAllCondition(@RequestParam(value = "name" ,defaultValue = "") String name,
                                                                 @RequestParam(value = "positionId" ,defaultValue = "-1") String positionId,
                                                                 @PageableDefault(value = MAXDISPLAY) Pageable pageable) {
        Page<Employee> employees = employeeService.findAllByFullNameContainingAndPosition(name, Integer.parseInt(positionId), pageable);
        return new ResponseEntity<>(employees.map(EmployeeViewDTO::new), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDeleteDTO> getEmployeeById(@PathVariable("id") String id) throws NotFoundById {
        return new ResponseEntity<>(new EmployeeDeleteDTO(employeeService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable("id") String id) {
        return new ResponseEntity<>(employeeService.updateIsDeleteById(id),HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeCreateDTO employee) {
        if(accountService.existsByEmployeeName(employee.getUsername()) != null){
            return ResponseEntity.badRequest().body("Tên tài khoản đã được sử dụng!");
        }
        if(employeeService.existsByEmployeeEmail(employee.getEmail()) != null){
            return ResponseEntity.badRequest().body("Email đã được sử dụng!");
        }
        if(employeeService.existsByEmployeeCardId(employee.getCardId()) != null){
            return ResponseEntity.badRequest().body("Chứng minh nhân dân đã được sử dụng!");
        }
        if(employeeService.existsByEmployeePhoneNumber(employee.getPhoneNumber()) != null){
            return ResponseEntity.badRequest().body("Số điện thoại đã được sử dụng!");
        }
//        String id = UUID.randomUUID().toString();
        String id = generate();
        Account account = new Account();
        account.setUsername(employee.getUsername());
        account.setPassword(employee.getPassword());
        account.setEnable(false);
        account.setDelete(false);
        accountService.addNewAccount(account);
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        Role role = new Role(2,"employee",false);
        accountRole.setRole(role);
        accountRole.setDelete(false);
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
        employee1.setId(id);
//        employee1.setId("id0055");
        return new ResponseEntity<>(employeeService.addNewEmployee(employee1), HttpStatus.CREATED);
    }

    @GetMapping("/employee/update/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String id)throws NotFoundById {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/employee/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeCreateDTO employee) throws NotFoundById {
        Employee employeePresent = employeeService.findById(employee.getId());
        if(employeeService.existsByEmployeeEmail(employee.getEmail()) != null && !employee.getEmail().equals(employeePresent.getEmail()) ){
            return ResponseEntity.badRequest().body("Email đã được sử dụng!");
        }
        if(employeeService.existsByEmployeePhoneNumber(employee.getPhoneNumber()) != null && !employee.getPhoneNumber().equals(employeePresent.getPhoneNumber())){
            return ResponseEntity.badRequest().body("Số điện thoại đã được sử dụng!");
        }
        Account account = new Account();
        account.setUsername(employee.getUsername());
        account.setPassword(employee.getPassword());
        account.setEnable(false);
        account.setDelete(false);
        accountService.addNewAccount(account);
        Employee employee1 = new Employee(
                employee.getId(),
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
        return new ResponseEntity<>(employeeService.addNewEmployee(employee1), HttpStatus.CREATED);
    }
}
