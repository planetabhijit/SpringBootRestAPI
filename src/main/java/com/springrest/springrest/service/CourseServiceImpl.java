package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service
@Repository
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(111, "Java Course", "Contains basic of Java"));
//		list.add(new Course(222, "Python Course", "Contains basic of python"));
//		list.add(new Course(333, "SQL Course", "Contains basic of SQl"));

//		return courseDao.findAll();
	}
	
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
//		return list;
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourseById(long courseId) {
		// TODO Auto-generated method stub
		
/*		Course c= null;
		
		for(Course course : list) {
			if(course.getId()==courseId) {
				c = course;
				break;
			}
		}
		return c;*/
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
/*		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
			
		});*/
		
		courseDao.save(course);
		
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourseById(Long valueOf) {
		// TODO Auto-generated method stub
//		list=this.list.stream().filter(e->e.getId()!=valueOf).collect(Collectors.toList());
		Course one = courseDao.findById(valueOf).get();
		courseDao.delete(one);
	}
	
}
