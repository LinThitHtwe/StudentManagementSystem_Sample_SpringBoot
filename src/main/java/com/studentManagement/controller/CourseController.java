package com.studentManagement.controller;

import com.studentManagement.model.Course;
import com.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String getAllCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "coursesTable";
    }

    @GetMapping("/add")
    public String addCoursePage(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Course course, Model model) {
        courseService.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateCoursePage(@PathVariable int id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "updateCourse";
    }

    @PatchMapping("/edit/{id}")
    public String updateCourse(@PathVariable int id, @ModelAttribute("course") Course course, Model model) {
        courseService.updateCourse(course);
        return "redirect:/";
    }

}
