package com.cruddemo.rest;

import com.cruddemo.entity.Employee;
import com.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }


    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

@GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);

        if(theEmployee==null)
        {
            throw new RuntimeException("Employee id not found"+ " "+employeeId);
        }

        return theEmployee;
}
@PostMapping()
public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee theEmployee=employeeService.save(employee);

        return theEmployee;
}
@PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee theEmployee=employeeService.save(employee);
         return theEmployee;
}

@DeleteMapping("/{id}")
public String deleteEmployee(@PathVariable int id) {

    Employee theEmployee = employeeService.findById(id);

    if (theEmployee == null) {
        throw new RuntimeException("Employee id not found" + " " + id);
    }

    employeeService.deleteById(id);
    return "deleted the id of" + id;
}
}

