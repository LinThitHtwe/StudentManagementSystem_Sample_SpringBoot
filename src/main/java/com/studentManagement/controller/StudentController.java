package com.studentManagement.controller;

import com.studentManagement.model.Course;
import com.studentManagement.model.Student;
import com.studentManagement.service.CourseService;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/studentTable";
    }

    @GetMapping("/add")
    public String addStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student, Model model,
                             @RequestParam("studentPhoto") MultipartFile studentPhoto,
                             @RequestParam("selectedCourseIds") int[] selectedCourseIds) {
        try {
            student.setPhoto(Base64.getEncoder().encodeToString(studentPhoto.getBytes()));
            List<Course> selectedCourses = new ArrayList<Course>();
            for (int courseId : selectedCourseIds) {
                Course course = courseService.getCourseById(courseId);
                selectedCourses.add(course);
            }
            for (Course course : selectedCourses) {
                student.getCourses().add(course);
            }

            studentService.addStudent(student);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/student/";
    }

    @GetMapping("/edit/{id}")
    public String updateStudentPage(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("allCourses", courses);
        return "student/updateStudent";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model,
                                @RequestParam("studentPhoto") MultipartFile studentPhoto,
                                @RequestParam("selectedCourseIds") int[] selectedCourseIds) {
        try {
            Student existingStudent = studentService.getStudentById(id);
            if (studentPhoto.isEmpty()) {
                student.setPhoto(existingStudent.getPhoto());
            } else {
                student.setPhoto(Base64.getEncoder().encodeToString(studentPhoto.getBytes()));
            }

            List<Course> selectedCourses = new ArrayList<Course>();
            for (int courseId : selectedCourseIds) {
                Course course = courseService.getCourseById(courseId);
                selectedCourses.add(course);
            }
            for (Course course : selectedCourses) {
                student.getCourses().add(course);
            }

            studentService.updateStudent(student);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/student/";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        System.out.println("Delete Method Called---" + id);
        studentService.deleteStudent(id);
        return "redirect:/student/";
    }

}
