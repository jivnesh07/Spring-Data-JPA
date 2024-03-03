package com.spring.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	//wrong import
//	Page<Course> finaByTitleContaining(
//	        String title,
//	        Pageable pageRequest
//	);
}
