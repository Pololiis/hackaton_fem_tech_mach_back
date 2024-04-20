package com.TheAngels.project.service;

import com.TheAngels.project.entity.User;

public interface UserService {
    User createUser(User user);
    User findUserById(Long id);
    User findUserByEmail(String email);
    User updateUser(User user);
}
