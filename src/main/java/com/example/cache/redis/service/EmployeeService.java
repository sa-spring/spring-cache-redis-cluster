package com.example.cache.redis.service;

import java.util.List;

import com.example.cache.redis.model.Employee;

public interface EmployeeService {

    Employee findEmployee(Long id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(long employeeId);
}
