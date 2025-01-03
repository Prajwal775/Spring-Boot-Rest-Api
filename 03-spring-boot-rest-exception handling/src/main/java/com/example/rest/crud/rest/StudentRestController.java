package com.example.rest.crud.rest;


import com.example.rest.crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;
    // define @PostConstruct to load the student data ...
    // only once when its given bean is constructed..


    //this approach is much better because we only load the student data once
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("piyush", "bharti"));
        theStudents.add(new Student("prajwal", "kumar"));
        theStudents.add(new Student("sneha", "kutthi"));
        theStudents.add(new Student("priyanka", "baluni"));


    }


    //path varaibles -retrieve a single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check the student id against the list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found -" + studentId);
        }
        return theStudents.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

    // List<Student> theStudents = new ArrayList<>();
    // theStudents.add(new Student("piyush","bharti"));
    // theStudents.add(new Student("prajwal","kumar"));
    // theStudents.add(new Student("sneha","kutthi"));
    // theStudents.add(new Student("priyanka","baluni"));

        return theStudents;
    }



}

