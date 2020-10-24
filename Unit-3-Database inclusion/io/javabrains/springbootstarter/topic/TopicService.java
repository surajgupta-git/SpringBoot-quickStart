package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//indicates that it is a business service and can be utilized by the controllers
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public  List<Topic> getAllTopics(){
		List <Topic> topics= new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic) {
		//inserts the topic if it does not exist, save can be used for both updating and inserting
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id); 
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	
}
