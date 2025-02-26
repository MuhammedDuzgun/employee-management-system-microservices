package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.dto.EmployeeResponseDto;
import com.javaguides.employeeservice.service.IEmployeeService;

import com.javaguides.employeeservice.service.openfeign.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;

    public EmployeeController(IEmployeeService employeeService, IDepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") Long id) throws Exception {
        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeResponseDto, HttpStatus.OK);
    }

}
