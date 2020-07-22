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
    
    //find student by id
    @GetMapping("/students/{id}")
    public ResponseEntity < Student > getStudentById(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
        Student student = studentService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
        return ResponseEntity.ok().body(student);
    }

	

    
	//delete student with specific id
	@DeleteMapping("/students/{id}")
    public Map < String, Boolean > deleteStudent(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
        Student student = studentService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " +id));

        studentService.delete(student);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
