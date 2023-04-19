package com.example.demo.controller.employee;

import com.example.demo.dto.EmployeeViewDTO;
import com.example.demo.model.employee.Employee;
import com.example.demo.service.impl.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin("/*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Page<EmployeeViewDTO>> getAllEmployees (@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        return new ResponseEntity<>(employees.map(EmployeeViewDTO::new), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Page<EmployeeViewDTO>> getAllEmployeesByNameContaining (@PageableDefault(value = 5) Pageable pageable,@PathVariable("name") String name) {
        Page<Employee> employees = employeeService.findAllByFullNameContaining(name, pageable);
        return new ResponseEntity<>(employees.map(EmployeeViewDTO::new), HttpStatus.OK);
    }

    @GetMapping("/{name}/{position_id}")
    public ResponseEntity<Page<EmployeeViewDTO>> getAllEmployeesByNameContainingAndPosition (@PageableDefault(value = 5) Pageable pageable,@PathVariable("name") String name, @PathVariable("position_id") String position_id) {
        Page<Employee> employees = employeeService.findAllByFullNameContainingAndPosition(name,Integer.parseInt(position_id), pageable);
        return new ResponseEntity<>(employees.map(EmployeeViewDTO::new), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeViewDTO> getEmployeeById (@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id).get();
        return new ResponseEntity<>(new EmployeeViewDTO(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        employeeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
