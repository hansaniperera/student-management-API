package com.example.firstAPI.controller;

import com.example.firstAPI.service.*;
import com.example.firstAPI.model.*;
import com.example.firstAPI.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    //find student by id
    @GetMapping("/students/{id}")
    public ResponseEntity < Student > getStudentById(@PathVariable(value = "id")final Integer id)
    throws ResourceNotFoundException {
        return ResponseEntity.ok().body(studentService.getById(id));
    }

	

    
	//delete student with specific id
	@DeleteMapping("/students/{id}")
    public HttpStatus deleteStudent(@PathVariable(value = "id")final Integer id)
    throws ResourceNotFoundException {
      
        this.studentService.deleteStudent(id);
	ResponseEntity.status(HttpStatus.OK);
	    return HttpStatus.OK;
    }
    
}
