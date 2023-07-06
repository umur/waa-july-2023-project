package com.example.alumni.controller;

import com.example.alumni.entity.dto.request.ResetUserPasswordRequest;
import com.example.alumni.entity.dto.request.ToggleUserStatusRequest;
import com.example.alumni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/city")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<List<User>> getByCity(@RequestParam String city) {
        return new ResponseEntity<>(userService.getAllByCity(city), HttpStatus.OK);
    }
    @GetMapping("/state")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<List<User>> getByState(@RequestParam String state) {
        return new ResponseEntity<>(userService.getAllByState(state), HttpStatus.OK);
    }

    @GetMapping("/major")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<List<User>> getByMajor(@RequestParam String major) {
        return new ResponseEntity<>(userService.getAllByMajor(major), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> add(@RequestBody User user) throws IllegalAccessException {
        User createdUser = userService.add(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) throws IllegalAccessException {
        Pair<Boolean, User> result = userService.update(user);
        return (!result.getFirst())
                ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
                : new ResponseEntity<User>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IllegalAccessException {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/toggle-user-status/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> toggleUserStatus(@PathVariable Long id,@RequestBody ToggleUserStatusRequest toggleUserStatusRequest) throws IllegalAccessException {
        User createdUser = userService.toggleUserStatus(toggleUserStatusRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.ACCEPTED);
    }

    @PutMapping("/reset-user-password/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<User> resetUserPassword(@PathVariable Long id,@RequestBody ResetUserPasswordRequest resetUserPasswordRequest) throws IllegalAccessException {
        User createdUser = userService.resetUserPassword(resetUserPasswordRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.ACCEPTED);
    }
}
