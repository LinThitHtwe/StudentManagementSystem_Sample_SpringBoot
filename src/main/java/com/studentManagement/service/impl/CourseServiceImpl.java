package com.studentManagement.service.impl;


import com.studentManagement.model.Course;
import com.studentManagement.repository.CourseRepository;
import com.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course addCourse(Course Course) {
        return courseRepository.save(Course);
    }

    @Override
    public Course updateCourse(Course Course) {
        return courseRepository.save(Course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
