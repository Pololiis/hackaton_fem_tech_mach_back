package com.TheAngels.project.service;

import com.TheAngels.project.entity.User;
import com.TheAngels.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public User findUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        User userToUpdate = userOptional.orElse(null);
        if(userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setIdDocument(user.getIdDocument());
            userToUpdate.setPhone(user.getPhone());
            userToUpdate.setPassword(user.getPassword());

            return userRepository.save(userToUpdate);
        }
        return null;
    }
}
