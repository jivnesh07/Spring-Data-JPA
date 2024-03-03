package com.spring.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.repository.CourseMaterialRepository;
import com.spring.data.jpa.entity.*;

@SpringBootTest
public class CourseMaterialrepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;
	
	
	
	@Test
	public void saveCourseMaterial() {
		Course course = new Course();
		course.setTitle("DAS");
		course.setCredit(6);
		
		CourseMaterial courseMaterial =  new CourseMaterial();
		courseMaterial.setUrl("www.dsa.com");
		courseMaterial.setCourse(course);
		
		repository.save(courseMaterial);
		
	}
	
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterial = repository.findAll();
		System.out.println("courseMaterials : " + courseMaterial);
	}

}
