package com.example.cache.redis.repository;

import java.util.List;

import com.example.cache.redis.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
}
