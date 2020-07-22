package com.example.firstAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//Creating a Spring Data Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
