package com.twohundred.alumni.controller;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;
import com.twohundred.alumni.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    UserService userService;

    @PostMapping("/activate/{id}")
    public void activateUser(@PathVariable Long id) {
        log.info("Activate user with id="+ id);
        User user = userService.getUser(id);
        user.setActive(Boolean.TRUE);
        userService.update(user);
    }

    @PostMapping("/deactivate/{id}")
    public void deactivateUser(@PathVariable Long id) {
        log.info("Deactivate user with id="+ id);
        User user = userService.getUser(id);
        user.setActive(Boolean.FALSE);
        userService.update(user);
    }

    @PostMapping("/lockuser/{id}")
    public void lockUser(@PathVariable Long id) {
        log.info("Lock user with id="+ id);
        User user = userService.getUser(id);
        user.setLocked(Boolean.TRUE);
        userService.update(user);
    }

    @PostMapping("/unlockuser/{id}")
    public void unLockUser(@PathVariable Long id) {
        log.info("Unlock user with id="+ id);
        User user = userService.getUser(id);
        user.setLocked(Boolean.FALSE);
        userService.update(user);
    }

    @LogMe
    @PutMapping("/reset-password")
    public void authenticate(@RequestBody UserPasswordResetDto userPasswordResetDto) {
        log.info("User password is going to be reset");
        userService.resetPassword(userPasswordResetDto);
    }
}