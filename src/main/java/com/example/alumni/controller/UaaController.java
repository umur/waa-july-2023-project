package com.example.alumni.controller;

import com.example.alumni.entity.User;
import com.example.alumni.entity.dto.request.LoginRequest;
import com.example.alumni.entity.dto.request.RefreshTokenRequest;
import com.example.alumni.entity.dto.request.SignUpRequest;
import com.example.alumni.entity.dto.response.LoginResponse;
import com.example.alumni.service.AuthService;
import com.example.alumni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UaaController {

    private final AuthService authService;

    private final UserService userService;

    @Autowired
    public UaaController(AuthService authService, UserService userService) {
        this.authService = authService;

        this.userService = userService;
    }


    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(signUpRequest.getPassword());

        user.setRoles(new ArrayList<>());

        user = userService.createUser(user);

        return ResponseEntity.ok(user);
    }
}

