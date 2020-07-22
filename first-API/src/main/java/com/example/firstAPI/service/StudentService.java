package com.example.firstAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstAPI.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
	
	public List<Student> getAll() {
        return this.studentRepository.findAll();
    }
}
