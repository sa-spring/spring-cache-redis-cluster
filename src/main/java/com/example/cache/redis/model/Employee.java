package com.example.cache.redis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private long employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeRole")
    private String employeeRole;

    // public long getEmployeeId() {
    // return employeeId;
    // }

    // public void setEmployeeId(long employeeId) {
    // this.employeeId = employeeId;
    // }

    // public String getEmployeeRole() {
    // return employeeRole;
    // }

    // public void setEmployeeRole(String employeeRole) {
    // this.employeeRole = employeeRole;
    // }

    // public String getEmployeeName() {
    // return employeeName;
    // }

    // public void setEmployeeName(String employeeName) {
    // this.employeeName = employeeName;
    // }
}
