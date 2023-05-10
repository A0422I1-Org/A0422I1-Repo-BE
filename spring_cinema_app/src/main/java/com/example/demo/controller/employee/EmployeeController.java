package com.example.demo.controller.employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.demo.dto.employee.EmployeeCreateDTO;
import com.example.demo.dto.employee.EmployeeDeleteDTO;
import com.example.demo.dto.employee.EmployeeViewDTO;
import com.example.demo.model.account.Account;
import com.example.demo.model.account.AccountRole;
import com.example.demo.model.account.Role;
import com.example.demo.model.employee.Employee;
import com.example.demo.service.account.IAccountRoleService;
import com.example.demo.service.account.IAccountService;
import com.example.demo.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    private static final int MAXDISPLAY = 5;
    private static int counter = 1;
    private static final String PATTERN = "Employee-%04d";

    public static String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = dateFormat.format(new Date());
        String id = String.format(PATTERN, counter++);
        return id + "-" + dateString;
    }

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IAccountRoleService accountRoleService;



    @GetMapping("/employee")
    public ResponseEntity<Page<EmployeeViewDTO>> getAllEmployeesByNameContainingAndPosition(@RequestParam(value = "name" ,defaultValue = "") String name,
                                                                                            @RequestParam(value = "positionId" ,defaultValue = "-1") String positionId,
                                                                                            @PageableDefault(value = MAXDISPLAY) Pageable pageable) {
        Page<Employee> employees = employeeService.findAllByFullNameContainingAndPosition(name, Integer.parseInt(positionId), pageable);
        return new ResponseEntity<>(employees.map(EmployeeViewDTO::new), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDeleteDTO> getEmployeeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(new EmployeeDeleteDTO(employeeService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable("id") String id) {
        return new ResponseEntity<>(employeeService.updateIsDeleteById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAllCustomer() {
        List<Employee> customers = (List<Employee>) employeeService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeCreateDTO employee) {
        if (accountService.existsByEmployeeName(employee.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Account đã tồn tại!");
        }
//        String id = UUID.randomUUID().toString();
        String id = generate();
        Account account = new Account();
        account.setUsername(employee.getUsername());
        account.setPassword(employee.getPassword());
        account.setIsEnable(false);
        account.setIsDelete(false);
        accountService.addNewAccount(account);
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        Role role = new Role(2, "employee", false);
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
        employee1.setId(id);
//        employee1.setId("id0055");
        return new ResponseEntity<>(employeeService.addNewEmployee(employee1), HttpStatus.CREATED);
    }

    @GetMapping("/employee/update/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(employeeService.finEById(id), HttpStatus.OK);
    }

    @PutMapping("/employee/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeCreateDTO employee) {
        Account account = new Account();
        account.setUsername(employee.getUsername());
        account.setPassword(employee.getPassword());
        account.setIsEnable(false);
        account.setIsDelete(false);
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
