package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	//helps in registering and creating an instance automatically of the topic service
	private TopicService topicService;
	
	@RequestMapping("/topics")
	//by default the method is GET, for post update and delete write explicitly
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	//{id} indicates that its a variable and its a viariable inside path
	public Topic getTopic(@PathVariable   String id) {
		return topicService.getTopic(id);
	}
	
	//@RequestMapping(method=RequestMethod.POST,value="/topics")
	//@requestBody get the instance of the topic from the URL request body section
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable   String id) {
		topicService.updateTopic(id,topic);
	} 
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic( @PathVariable   String id) {
		topicService.deleteTopic(id);
	}
	
		
}
