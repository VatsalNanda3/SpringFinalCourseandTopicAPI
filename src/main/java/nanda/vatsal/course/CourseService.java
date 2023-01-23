package nanda.vatsal.course;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@EnableAutoConfiguration

@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses=new ArrayList<>();
		
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add); //Uses a lambda function to populate the list using the add method
		
		return courses;
	} 
	
	
	public Course getCourse(String id)
	{
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();//from the topics list, we 
	
		//we use the topics stream, filter it using a lambda function where for every element in the list, we check the id and we get the very first topic element and we get it.
		
		Course t=courseRepository.findById(id).get();
		
		return t;
	}


	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
		courseRepository.save(course);
	}


	public void updateCourse(Course course) {
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
		
		courseRepository.save(course);
		
		
		
	}


	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		
		//topics.removeIf(t-> t.getId().equals(id));
		
		courseRepository.deleteById(id);
		
	}

}
