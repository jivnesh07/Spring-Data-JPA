package com.spring.data.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.repository.StudentRepository;
import com.spring.data.jpa.entity.Student;
import com.spring.data.jpa.entity.Guardian;

@SpringBootTest
class StudentRepositoryTest {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = new Student();
		student.setEmailId("Ankit@gmail.com");
		student.setFirstName("Ankit");
		student.setLastName("");
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println(studentList.toString());
	}
	
	@Test
	public void saveStudentWithGuardian() {
		 Guardian guardian = new Guardian();
		 guardian.setEmail("Nikhil@gmail.com");
		 guardian.setName("Nikhil");
		 guardian.setMobileNumber("9999999999");
		 
		 Student student = new Student();
		 student.setEmailId("Shivan@gmail.com");
		 student.setFirstName("Shivam");
		 student.setLastName("Kumar");
		 student.setGuardian(guardian);
		 
		 studentRepository.save(student);
		 
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> listOfStudents = studentRepository.findByFirstName("Shivam");
		System.out.println("Students --->  " + listOfStudents);
		
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> listOfStudents = studentRepository.findByFirstNameContaining("Sh");
		System.out.println(listOfStudents);
	}
	
	@Test
	public void printStudentWhereLastNameNotNull() {
		List<Student> listOfStudents = studentRepository.findByLastNameNotNull();
		for(int i=0; i<listOfStudents.size();i++) {
			System.out.println("Student " + " = " + listOfStudents.get(i));
		}
	}
	
	
	@Test
	public void printGetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("raj@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void printGetStudentFirstNameByEmailAddress() {
		String studentFirstname= studentRepository.getStudentFirstNameByEmailAddress("raj@gmail.com");
		System.out.println(studentFirstname);
	}
	
	@Test
	public void printGetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("raj@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("Rajendra", "raj@gmail.com");
	}

}
