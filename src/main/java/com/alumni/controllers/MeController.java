package com.alumni.controllers;

import com.alumni.entity.BaseUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/me")
@AllArgsConstructor
public class MeController {

    @GetMapping
    public ResponseEntity get(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BaseUser baseUser = (BaseUser)authentication.getPrincipal();

//        System.out.println("authentication" + authentication);
//        FacultyResponseDTO

        System.out.println("baseUser" + baseUser);
        System.out.println("id" + baseUser.getId());

        return ResponseEntity.ok("");
    }

}
