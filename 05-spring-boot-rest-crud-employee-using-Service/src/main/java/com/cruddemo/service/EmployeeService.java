package com.cruddemo.service;

import com.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findbyId(int theId);
    Employee save(Employee theEmployee);
    void deletebyId(int theId);
}
