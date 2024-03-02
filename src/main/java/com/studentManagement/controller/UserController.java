package com.studentManagement.controller;

import com.studentManagement.model.User;
import com.studentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersTable";
    }

    @GetMapping("/add")
    public String addUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUserPage(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user, Model model) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
