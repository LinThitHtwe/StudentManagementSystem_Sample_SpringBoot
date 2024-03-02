package com.studentManagement.service;

import com.studentManagement.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

}
