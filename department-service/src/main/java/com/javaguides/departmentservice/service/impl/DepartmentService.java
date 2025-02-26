package com.javaguides.departmentservice.service.impl;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.repository.IDepartmentRepository;
import com.javaguides.departmentservice.service.IDepartmentService;
import com.javaguides.departmentservice.utils.DepartmentMapper;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(IDepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department departmentToSave = departmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(departmentToSave);
        return departmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return departmentMapper.mapToDepartmentDto(department);
    }

}
