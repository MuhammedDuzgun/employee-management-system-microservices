package com.javaguides.employeeservice.repository;

import com.javaguides.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
