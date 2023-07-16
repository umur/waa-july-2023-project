package com.example.geeks.controller;


import com.example.geeks.entity.User;
import com.example.geeks.entity.dtos.UserDTO;
import com.example.geeks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {


    //DONOT FORGET TO USE PASS AND USERNAMR(USER) IN HEADERS
    private final  UserService uss;

    /*
    @PostMapping
    @ResponseBody
    public User addUser(@RequestBody User user) {
        User savedUser = uss.addUser(user);
        return savedUser;
    }
    */
    @GetMapping
    @ResponseBody
    public List<UserDTO> getAllUsers() {
        List<User> users = uss.getAllUsers();
        //return users;
        return users.stream().map(user -> {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(user, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = uss.getUser(id);
        return user.orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        uss.deleteUser(id);
    }

    @GetMapping("/whereIdHas/{id}")
    @ResponseBody
    public List<User> getUsersWhereIdHas(@PathVariable Long id) {
        List<User> users = uss.getUsersWhereIdHas(id);
        return users;
    }

    @GetMapping("/byCity/{city}")
    @ResponseBody
    public List<User> getUsersByCity(@PathVariable String city) {
        List<User> users = uss.getUsersByCity(city);
        return users;
    }

    @GetMapping("/byState/{state}")
    @ResponseBody
    public List<User> getUsersByState(@PathVariable String state) {
        List<User> users = uss.getUsersByState(state);
        return users;
    }

    @GetMapping("/whereNameHas/{name}")
    @ResponseBody
    public List<User> getUsersWhereNameHas(@PathVariable String name) {
        List<User> users = uss.getUsersWhereNameHas(name);
        return users;
    }

    @GetMapping("/studentByMajor/{major}")
    @ResponseBody
    public List<User> getStudentByMajor(@PathVariable String major) {
        List<User> users = uss.getStudentByMajor(major);
        return users;
    }

//    @DeleteMapping("/activate/{id}")
//    @ResponseBody
//    public void activateUser(@PathVariable Long id) {
//        uss.deleteUser(id);
//    }
//
//    @DeleteMapping("/deactivate/{id}")
//    @ResponseBody
//    public void deActivateUser(@PathVariable Long id) {
//        uss.deleteUser(id);
//    }
}
