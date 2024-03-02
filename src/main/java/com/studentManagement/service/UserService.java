package com.studentManagement.service;

import com.studentManagement.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();
}
