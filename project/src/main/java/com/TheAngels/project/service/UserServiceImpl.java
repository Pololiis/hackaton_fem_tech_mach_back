package com.TheAngels.project.service;

import com.TheAngels.project.entity.User;
import com.TheAngels.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        if(user != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = findUserByEmail(user.getEmail());
        if(userToUpdate != null) {
            return userRepository.save(user);
        }
        return null;
    }
}
