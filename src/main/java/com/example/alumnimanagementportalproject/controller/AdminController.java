package com.example.alumnimanagementportalproject.controller;

import com.example.alumnimanagementportalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody String username, @RequestBody String password) {
        return "admin";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser() {
        return "deleteUser";
    }

   @RequestMapping("/updateUser")
    public String updateUser() {
        return "updateUser";
    }


}
