package com.twohundred.alumni.controller;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.UserDto;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;
import com.twohundred.alumni.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    UserService userService;

    @LogMe
    @GetMapping("/all-users")
    public List<UserDto> getAllUser() {
        log.info("Get all users");
        List<User> users = userService.findAll();
        return users.stream().map(user -> new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRoles().stream().map(role -> role.getRole()).collect(Collectors.joining(",")),
                user.getLocked(),
                user.getActive())).toList();
    }

    @LogMe
    @PutMapping("/active/{id}")
    public void activate(@PathVariable long id, @RequestParam boolean active) {
        log.info("Activate/Deactive user with id="+ id);
        User user = userService.getUser(id);
        user.setActive(active);
        userService.update(user);
    }

    @LogMe
    @PutMapping("/lock/{id}")
    public void lock(@PathVariable long id, @RequestParam boolean locked) {
        log.info("Lock/Unlock user with id="+ id);
        User user = userService.getUser(id);
        user.setLocked(locked);
        userService.update(user);
    }

    @LogMe
    @PutMapping("/reset-password")
    public void authenticate(@RequestBody UserPasswordResetDto userPasswordResetDto) {
        log.info("User password is going to be reset");
        userService.resetPassword(userPasswordResetDto);
    }
}