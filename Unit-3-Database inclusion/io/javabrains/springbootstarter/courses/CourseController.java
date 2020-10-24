package io.javabrains.springbootstarter.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	//helps in registering and creating an instance automatically of the topic service
	private CourseService CourseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	//by default the method is GET, for post update and delete write explicitly
	public List<Course> getAllCourses(@PathVariable String topicId){
		return CourseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	//{id} indicates that its a variable and its a variable inside path
	public Optional<Course> getCourse(@PathVariable String id) {
		return CourseService.getCourse(id);
	}
	
	//@RequestMapping(method=RequestMethod.POST,value="/topics")
	//@requestBody get the instance of the topic from the URL request body section
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		CourseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,  @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		CourseService.updateCourse(course);
	} 
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteCourse( @PathVariable String id) {
		CourseService.deleteCourse(id);
	}
	
		
}
