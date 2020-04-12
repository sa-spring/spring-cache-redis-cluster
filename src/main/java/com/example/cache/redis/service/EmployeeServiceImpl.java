package com.example.cache.redis.service;

import java.util.List;
import java.util.Optional;

import com.example.cache.redis.model.Employee;
import com.example.cache.redis.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employees")
    public List<Employee> findAll() {
        log.info("All found");
        return employeeRepository.findAll();
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public void delete(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            log.info("Deleted");
        } else {
            log.info("Delete failed");
        }
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public Employee save(Employee employee) {
        log.info("Saved");
        return employeeRepository.save(employee);
    }

    @Override
    @Cacheable(value = "employees", key = "#id")
    public Employee findEmployee(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            log.info("Found one");
            return employee.get();
        } else {
            log.info("Not found");
            return null;
        }
    }
}
