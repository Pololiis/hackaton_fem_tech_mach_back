package com.TheAngels.project.controller;

import com.TheAngels.project.entity.LoginRequest;
import com.TheAngels.project.entity.LoginResponse;
import com.TheAngels.project.entity.User;
import com.TheAngels.project.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest user) {
        LoginResponse authenticatedUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
