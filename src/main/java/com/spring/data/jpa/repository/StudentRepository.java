package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	//get students by first name
	public List<Student> findByFirstName(String firstName);
	
	//get students by first name containing some char
	public List<Student> findByFirstNameContaining(String firstName);
	
	// get students where last name is not null
	public List<Student> findByLastNameNotNull();
	
	//get student by guardian name
	public List<Student> findByGuardianName(String guardianName);
	

}
