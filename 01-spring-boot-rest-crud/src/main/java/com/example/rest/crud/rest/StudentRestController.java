package com.example.rest.crud.rest;


import com.example.rest.crud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    @GetMapping("/details")
    public List<Student> getStudents()
    {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("piyush","bharti"));
        theStudents.add(new Student("prajwal","kumar"));
        theStudents.add(new Student("sneha","kutthi"));
        theStudents.add(new Student("priyanka","baluni"));

        return theStudents;
    }
}
