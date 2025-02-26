package com.javaguides.departmentservice.config;

import com.javaguides.departmentservice.utils.DepartmentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DepartmentMapper departmentMapper() {
        return new DepartmentMapper();
    }

}
