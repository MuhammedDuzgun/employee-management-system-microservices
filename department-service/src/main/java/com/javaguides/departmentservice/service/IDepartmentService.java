package com.javaguides.departmentservice.service;

import com.javaguides.departmentservice.dto.DepartmentDto;

public interface IDepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByDepartmentCode(String departmentCode);

}
