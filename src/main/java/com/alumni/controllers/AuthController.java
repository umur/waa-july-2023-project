package com.alumni.controllers;

import com.alumni.Service.AuthService;
import com.alumni.dtos.request.LoginRequestDTO;
import com.alumni.dtos.request.SignupRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {


    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDTO requestData) {
        return new ResponseEntity(authService.signup(requestData), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity(authService.login(loginRequestDTO), HttpStatus.OK);
    }


}
