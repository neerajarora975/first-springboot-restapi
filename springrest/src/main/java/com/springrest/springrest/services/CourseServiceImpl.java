package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

// import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	List<Course> list;
	
	

	public CourseServiceImpl() {

		list = new ArrayList<>();
		list.add(new Course(145, "Java Core", "Core Java basics"));
		list.add(new Course(155, "Java Spring", "Java Spring FM"));
				
	}



	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}



	@Override
	public Course getCourse(long courseId) {
		
		Course c=null;
		
		for (Course course : list) 
			if (course.getId()==courseId) {
			  c=course;
			  break;
			}
		return c;
	}



	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		// (parameter list) -> lambda body - anonymous inline func
		list.forEach(c -> {
			if (c.getId() == course.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
		});
		return course;
	}



	@Override
	public void deleteCourse(long lcourseId) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=lcourseId).collect(Collectors.toList());
	}
}
