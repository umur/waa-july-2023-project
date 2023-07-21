package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.dto.LoginRequest;
import com.miu.waa.aluminimanagement.model.dto.RegisterDto;
import com.miu.waa.aluminimanagement.model.dto.RoleDto;
import com.miu.waa.aluminimanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        var loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @GetMapping("/roles")
    public List<RoleDto> findAllRoles(){
        return userService.findAllRoles();
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto registerDto){
        userService.register(registerDto);
    }
}
