package edu.mum.cs.cs425.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.model.Course;
import edu.mum.cs.cs425.repository.CourseRepository;
import edu.mum.cs.cs425.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);	
	}

}
