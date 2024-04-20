package com.TheAngels.project.service;

import com.TheAngels.project.entity.LoginResponse;
import com.TheAngels.project.entity.User;
import com.TheAngels.project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EncryptServiceImpl encryptService;
    private final JwtServiceImpl jwtService;
    @Override
    public User createUser(User user) {
        if(user != null) {
            String hashPassword = encryptService.encryptPassword(user.getPassword());
            user.setPassword(hashPassword);
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
    public LoginResponse loginUser(String email, String password) {
        User loginUser = userRepository.findUserByEmail(email);
        if (loginUser != null) {
            Boolean passwordMatched = encryptService.verifyPassword(password, loginUser.getPassword());
            if (passwordMatched) {
                LoginResponse user = new LoginResponse();
                user.setName(loginUser.getName());
                user.setLastName(loginUser.getLastName());
                user.setPhone(loginUser.getPhone());
                user.setToken(jwtService.buildJwt());
                return user;
            }
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
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
