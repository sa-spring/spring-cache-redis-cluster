package com.example.cache.redis;

import com.example.cache.redis.model.Employee;
import com.example.cache.redis.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableCaching
public class EmployeeApplication implements ApplicationRunner {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeService.save(new Employee(1L, "Tom", "CAT"));
        employeeService.save(new Employee(2L, "Jerry", "MICE"));
        employeeService.save(new Employee(3L, "Alice", "GIRL"));
        employeeService.save(new Employee(4L, "Bob", "BOY"));

    }
}
