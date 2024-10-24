package com.example.testingTask;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email is required")
    private String email;


    public RegisterRequest() {}


    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;

    }


}
