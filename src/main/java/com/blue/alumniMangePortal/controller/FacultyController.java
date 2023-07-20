package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.service.AddressService;
import com.blue.alumniMangePortal.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AddressService addressService;


    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @GetMapping("/{id}")
    public Faculty getFactuly(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/email/{email}")
    public Faculty getFacultyByEmail(@PathVariable String email) {
        return facultyService.getFacultyByEmail(email);
    }

    @PutMapping("/{id}/faculty")
    void updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/{id}")
    void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }
}