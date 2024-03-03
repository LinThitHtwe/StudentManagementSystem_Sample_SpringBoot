package com.studentManagement.controller;

import com.studentManagement.model.Student;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/studentsTable";
    }

    @GetMapping("/add")
    public String addStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student, Model model) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateStudentPage(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/updateStudent";
    }

    @PatchMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
        studentService.updateStudent(student);
        return "redirect:/";
    }

}
