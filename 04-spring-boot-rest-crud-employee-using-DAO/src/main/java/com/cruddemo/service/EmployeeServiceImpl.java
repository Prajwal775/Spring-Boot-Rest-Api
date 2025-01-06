package com.cruddemo.service;

import com.cruddemo.dao.EmployeeDAO;
import com.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
        private EmployeeDAO employeeDAO;


        @Autowired
        public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO){
            employeeDAO=theEmployeeDAO;

        }
        @Override
        public List<Employee> findAll() {

        return employeeDAO.findAll();
    }
}
