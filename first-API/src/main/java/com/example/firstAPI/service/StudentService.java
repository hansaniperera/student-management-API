package com.example.firstAPI.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstAPI.repository.StudentRepository;
import com.example.firstAPI.model.*;
import com.example.firstAPI.exception.*;

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
	
    	public Student getById(long id) throws ResourceNotFoundException {
        Optional<Student> studentDb = this.studentRepository.findById((int) id);
        if (studentDb.isPresent()) {
            return studentDb.get();
        } else {
            throw new ResourceNotFoundException("Student not found with Id :" + id);
        }
    }

    	public void deleteStudent(long id) {
        	Optional<Student> studentDb = this.studentRepository.findById((int) id);
        	if (studentDb.isPresent()){
            		this.studentRepository.delete(studentDb.get());
        	}
		else{
            		try {
                		throw new ResourceNotFoundException("Student not found with Id :"+id);
            		} catch (ResourceNotFoundException e) {
                	e.printStackTrace();
            		}
		}		
        }		
}
