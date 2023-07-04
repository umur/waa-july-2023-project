package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.dto.StudentJob;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/registerStudent")
    public String registerStudent(@RequestBody Student student){
        return null;
    }
    @PutMapping("/updateProfile")
    public String updateProfile(@PathVariable Long id, @RequestBody Student student){
        return null;
    }
    @PostMapping("/addJobAdverts")
    public String addJobAdverts(@RequestBody StudentJob studentJob){
        return null;
    }
    @GetMapping("/seeCv/{id}")
    public String seeStudentCv(@PathVariable Long id){
        System.out.println("get CV file");
        return null;
    }
    @GetMapping("/getById/{id}")
    public String getStudentById(@PathVariable Long id) {
        return null;
    }
    @GetMapping("/")
    public List<Student> getAllStudents(){
        return null;
    }
    @PostMapping("/addprofessionalExperience")
    public String addJobExperience(@RequestBody String jobExperience){
        return null;
    }
    @PutMapping("/resetPassword/{password}")
    public String resetPassword(@PathVariable String password){
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return null;
    }

}
