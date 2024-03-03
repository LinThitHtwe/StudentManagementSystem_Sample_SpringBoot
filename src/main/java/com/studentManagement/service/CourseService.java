package com.studentManagement.service;

import com.studentManagement.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course updateCourse(Course course);

    Course getCourseById(int id);

    List<Course> getAllCourses();

    Course getCourseByName(String name);
}
