package com.twohundred.alumni.controller;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.Experience;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.ExperienceDto;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;
import com.twohundred.alumni.service.UserService;
import com.twohundred.alumni.service.impl.ExperienceServiceImpl;
import com.twohundred.alumni.service.impl.StudentServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PreAuthorize("hasAnyAuthority('ADMIN', 'FACULTY', 'STUDENT')")
public class UserController {

    @Autowired
    UserService userService;

    @LogMe
    @PutMapping("/reset-password")
    public void authenticate(@RequestBody UserPasswordResetDto userPasswordResetDto) {
        log.info("User password is going to be reset");
        userService.resetPassword(userPasswordResetDto);
    }
}
