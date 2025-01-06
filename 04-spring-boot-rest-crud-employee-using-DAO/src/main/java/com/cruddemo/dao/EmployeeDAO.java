package com.cruddemo.dao;

import com.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findbyId(int theId);
    Employee save(Employee theEmployee);
    void deletebyId(int theId);
}
