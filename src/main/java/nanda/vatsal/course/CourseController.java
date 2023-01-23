package nanda.vatsal.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nanda.vatsal.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{id}/courses") //GET Request
	public List<Course> getAllCourses(@PathVariable String id) {
		
		return courseService.getAllCourses(id); //GET Request
	}
	
	
	@RequestMapping("/topics/{topicId}/courses/{id}") // GET/id Request
	public Course getCourse(@PathVariable String id)// PathVariable annotation is added to tell spring that the id that is being 
	
	//passed as a function argument is the same as the id that we will pass in the local host 
	{
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course ,@PathVariable String id,@PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		
		courseService.deleteCourse(id);
	}
	

}
