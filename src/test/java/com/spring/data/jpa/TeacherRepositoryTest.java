package com.spring.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.repository.TeacherRepository;
import com.spring.data.jpa.entity.*;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	
	@Test
	public void saveTeacher() {
		
		Course coursePython = new Course();
		coursePython.setTitle("Python");
		coursePython.setCredit(5);
		
		Course courseJava = new Course();
		courseJava.setTitle("Java");
		courseJava.setCredit(4);
		
		Teacher teacher = new Teacher();
		teacher.setFirstName("Mohit");
		teacher.setLastName("Patel");
//		teacher.setCourses(List.of(coursePython,courseJava));
		
		repository.save(teacher);
	}
	
	

}
