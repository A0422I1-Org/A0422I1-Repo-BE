package com.example.demo.controller.employee;

import com.example.demo.dto.employee.EmployeeDeleteDTO;
import com.example.demo.dto.employee.EmployeeViewDTO;
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
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmployeeController {
    private static final int MAXDISPLAY = 5;
    @Autowired
    private EmployeeService employeeService;


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
}
