package org.example.rest.controller;

import org.example.rest.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId >= students.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

    // exception handler for studentId searching if not exist, using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
