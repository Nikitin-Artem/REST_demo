package org.example.rest.controller;

import org.example.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstructor to load the student data only once
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("Porrima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define all students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define single student by id
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        
        return students.get(studentId);
    }
}
