package com.javaguides.employeeservice.service;

import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.dto.EmployeeResponseDto;

public interface IEmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeResponseDto getEmployeeById(Long id) throws Exception;
}
