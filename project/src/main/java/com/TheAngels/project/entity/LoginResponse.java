package com.TheAngels.project.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginResponse {
    private String name;
    private String lastName;
    private String phone;
}
