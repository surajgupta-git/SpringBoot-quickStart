package io.javabrains.springbootstarter.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
	
	public List<Course> findByTopicId(String topicId);
		//Feature: no need to implement as spring JPA will inherently implement it
}
