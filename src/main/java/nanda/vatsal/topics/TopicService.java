package nanda.vatsal.topics;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@EnableAutoConfiguration

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework", "Spring framework desc"),
			
			new Topic("java","core java", "core java desc"),
			
			new Topic("javascript","Javascript", "Javascript desc")
		 				));
	
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics=new ArrayList<>();
		
		topicRepository.findAll()
		.forEach(topics::add); //Uses a lambda function to populate the list using the add method
		
		return topics;
	} 
	
	
	public Topic getTopic(String id)
	{
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();//from the topics list, we 
	
		//we use the topics stream, filter it using a lambda function where for every element in the list, we check the id and we get the very first topic element and we get it.
		
		Topic t=topicRepository.findById(id).get();
		
		return t;
	}


	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		
		topicRepository.save(topic);
	}


	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		
		
//		for(int i=0;i<topics.size();i++)
//		{
//			Topic t=topics.get(i);
//			
//			if(t.getId().equals(id))
//			{
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
		
		
		
	}


	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		
		//topics.removeIf(t-> t.getId().equals(id));
		
		topicRepository.deleteById(id);
		
	}

}
