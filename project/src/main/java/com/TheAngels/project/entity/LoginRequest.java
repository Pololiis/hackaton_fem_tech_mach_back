package com.TheAngels.project.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
