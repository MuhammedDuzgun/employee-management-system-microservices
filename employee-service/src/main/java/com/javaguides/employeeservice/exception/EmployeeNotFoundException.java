package com.javaguides.employeeservice.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Employee with id : "+ id + " Not Found");
    }
}
