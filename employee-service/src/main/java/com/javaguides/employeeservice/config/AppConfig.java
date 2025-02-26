package com.javaguides.employeeservice.config;

import com.javaguides.employeeservice.utils.EmployeeMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeMapper employeeMapper() {
        return new EmployeeMapper();
    }

}
