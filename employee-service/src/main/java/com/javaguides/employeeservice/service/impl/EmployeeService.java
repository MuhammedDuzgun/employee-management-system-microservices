package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.dto.EmployeeResponseDto;
import com.javaguides.employeeservice.dto.OrganizationDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.exception.EmployeeNotFoundException;
import com.javaguides.employeeservice.repository.IEmployeeRepository;
import com.javaguides.employeeservice.service.IEmployeeService;
import com.javaguides.employeeservice.service.openfeign.IDepartmentService;
import com.javaguides.employeeservice.service.openfeign.IOrganizationService;
import com.javaguides.employeeservice.utils.EmployeeMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final IDepartmentService departmentService;
    private final IOrganizationService organizationService;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(IEmployeeRepository employeeRepository, EmployeeMapper employeeMapper,
                           IDepartmentService departmentService, IOrganizationService organizationService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentService = departmentService;
        this.organizationService = organizationService;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employeeToSave = employeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employeeToSave);
        return employeeMapper.mapToEmployeeDto(employeeToSave);
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getEmployeeByIdWithDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getEmployeeByIdWithDefaultDepartment")
    @Override
    public EmployeeResponseDto getEmployeeById(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(employee);

        DepartmentDto departmentDto =
                departmentService.getDepartmentByDepartmentCode(employeeDto.getDepartmentCode());

        OrganizationDto organizationDto =
                organizationService.getOrganization(employeeDto.getOrganizationCode());

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setEmployeeDto(employeeDto);
        employeeResponseDto.setDepartmentDto(departmentDto);
        employeeResponseDto.setOrganizationDto(organizationDto);

        return employeeResponseDto;
    }

    //default-department
    public EmployeeResponseDto getEmployeeByIdWithDefaultDepartment(Long id, Exception e) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(0L);
        departmentDto.setDepartmentName("DEFAULT DEPARTMENT");
        departmentDto.setDepartmentDescription("default department");
        departmentDto.setDepartmentCode("999");

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setEmployeeDto(employeeDto);
        employeeResponseDto.setDepartmentDto(departmentDto);

        return employeeResponseDto;
    }


}
