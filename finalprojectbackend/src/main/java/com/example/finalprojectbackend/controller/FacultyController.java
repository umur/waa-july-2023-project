package com.example.finalprojectbackend.controller;

import com.example.finalprojectbackend.entity.Faculty;
import com.example.finalprojectbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:3000")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        List<Faculty> faculties = facultyService.getAllFaculty();
        return ResponseEntity.ok(faculties);
    }

    @PutMapping("/update")
    public ResponseEntity <Faculty> updateFaculty(@RequestBody Faculty faculty){

        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updateFaculty);
    }
}
