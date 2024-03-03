package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	//get student by email address using Query annotation with JPQL queries
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String emailID);
	
	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailAddress(String emailID);
	
	//get student by email address using Query annotation with Native SQL queries
	//this way can be used when you have some complex queries to execute
	@Query(
			value="select * from tbl_student s where s.email_address=?1",
			nativeQuery= true
	)
	Student getStudentByEmailAddressNative(String emailID);
	

	//Native query with named param
	//get student by email address using Query annotation with Native SQL queries
		//this way can be used when you have some complex queries to execute
		@Query(
				value="select * from tbl_student s where s.email_address= :emailId",
				nativeQuery= true
		)
		Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
		
		
	
	//updating a record in db
	@Modifying
	@Transactional
	@Query(
	     value = "update tbl_student set first_name =?1 where email_address=?2",
	     nativeQuery=true
	)
	int updateStudentNameByEmailId(String firstName, String emailId);
	
}
