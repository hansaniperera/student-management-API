package com.example.firstAPI.controller;

import firstAPI.exception.ResourceNotFoundException;
import firstAPI.model.Student;
import firstAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    // get all students
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok().body(studentService.getAll());
    }

    // create new student
    @PostMapping("/student")
    public ResponseEntity <Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.createStudent(student));
    }
}