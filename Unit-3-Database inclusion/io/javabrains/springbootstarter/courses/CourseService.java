package io.javabrains.springbootstarter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//indicates that it is a business service and can be utilized by the controllers
public class CourseService {
	
	@Autowired
	private CourseRepository CourseRepository;
	
	public  List<Course> getAllCourses(String topicId){
		List <Course> courses= new ArrayList<>();
		CourseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		return CourseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
		CourseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		CourseRepository.deleteById(id); 
	}
	
	public void updateCourse(Course course) {
		CourseRepository.save(course);
	}
	
	
}
