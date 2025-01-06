package com.cruddemo.dao;

import com.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findbyId(int theId) {
        //get or find employee
        Employee theEmployee =entityManager.find(Employee.class,theId);
        // return that empployee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save or update
        Employee dbEmployee=entityManager.merge(theEmployee);

        //return the employee
        return dbEmployee;
    }

    @Override
    public void deletebyId(int theId) {

        Employee theEmployee=entityManager.find(Employee.class,theId);

        entityManager.remove(theEmployee);

         }
}

