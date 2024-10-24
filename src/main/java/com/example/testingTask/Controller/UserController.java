package com.example.testingTask.Controller;

import com.example.testingTask.*;
import com.example.testingTask.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.RemoteRef;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        String defaultRole = "USER";
        userService.registerUser(user.getUsername(), user.getPassword(), defaultRole);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtTokenProvider.createToken(String.valueOf(authentication));

        return ResponseEntity.ok(new AuthResponse(token));

    }
}
