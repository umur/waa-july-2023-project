package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.service.AddressService;
import com.blue.alumniMangePortal.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumniMangePortal/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AddressService addressService;

    @PostMapping
    public void addFaculty(@RequestBody Faculty faculty) {
        Address address = faculty.getAddress();
        addressService.saveAddress(address);
        faculty.setAddress(address);
        facultyService.addFaculty(faculty);
    }

    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @GetMapping("/{id}")
    public Faculty getFactuly(@PathVariable Long id) {
        return facultyService.getFaculty(id);
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