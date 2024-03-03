package com.spring.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.repository.CourseRepository;
import com.spring.data.jpa.entity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;
	
	
	@Test
	public void printCourse() {
		List<Course> courses = repository.findAll();
		System.out.println("Courses : " + courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Parag");
		teacher.setLastName("Singh");
		
		Course course = new Course();
		course.setTitle(".Net");
		course.setCredit(6);
		course.setTeacher(teacher);
		
		repository.save(course);	
		
	}
	
	@Test
	public void finalAllPagination() {
		Pageable firstpageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = repository.findAll(firstpageWithThreeRecords).getContent();
		
		long totalElements = repository.findAll(firstpageWithThreeRecords).getTotalElements();
		
		long totalPages = repository.findAll(firstpageWithThreeRecords).getTotalPages();

		
		System.out.println("totalElements : "+ totalElements);
		
		System.out.println("totalPages : "+ totalPages);
		
		System.out.println("Courses : " + courses);
		
	}
	
	@Test
	public void findAllSorting() {
		
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc= PageRequest.of(0, 2, 
				Sort.by("title").descending().and(Sort.by("credit").descending()));
		
		List<Course> coursesWithSortByTitle = repository.findAll(sortByTitle).getContent();
		List<Course> coursesWithSortByCreditDesc = repository.findAll(sortByCreditDesc).getContent();
		List<Course> coursesWithSortByTitleAndCreditDesc = repository.findAll(sortByTitleAndCreditDesc).getContent();


		System.out.println("coursesWithSortByTitle : " + coursesWithSortByTitle);
		System.out.println("coursesWithSortByCreditDesc : " + coursesWithSortByCreditDesc);
		System.out.println("coursesWithSortByTitleAndCreditDesc : " + coursesWithSortByTitleAndCreditDesc);


	}
	
//	@Test
//	public void printFindByTitleContaining() {
//		
//		Pageable firstPageTenRecords = PageRequest.of(0, 10);
//		
//		List<Course> course = repository.finaByTitleContaining("D", firstPageTenRecords).getContent();
//		
//		System.out.println("Courses : " + course);
//
//		
//	}
	
	
	@Test
	public void saveCourseWIthStudentAndTeacher() {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Liza");
		teacher.setLastName("Morgan");
		
		Student student = new Student();
		student.setFirstName("Abhishek");
		student.setLastName("Singh");
		student.setEmailId("Abhishek@gmail.com");
		
		Course course = new Course();
		course.setTitle("AI");
		course.setCredit(12);
		course.setTeacher(teacher);
		
		course.addStudents(student);
		
		repository.save(course);
	}

}
