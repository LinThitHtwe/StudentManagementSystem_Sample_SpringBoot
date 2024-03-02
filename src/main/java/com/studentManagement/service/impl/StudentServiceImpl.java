package com.studentManagement.service.impl;


import com.studentManagement.model.Student;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student user) {
        return studentRepository.save(user);
    }

    @Override
    public Student updateStudent(Student user) {
        return studentRepository.save(user);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
