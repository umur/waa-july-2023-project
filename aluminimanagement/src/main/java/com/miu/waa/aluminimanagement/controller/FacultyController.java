package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.service.FacultyService;
import com.miu.waa.aluminimanagement.service.FacultyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService service;

    @GetMapping()
    public List<Faculty> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Faculty> findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    public Faculty save(@RequestBody Faculty faculty) {
        return service.save(faculty);
    }

    @PutMapping("{id}")
    public Faculty update(@PathVariable Long id, @RequestBody Faculty faculty) {
        faculty.setId(id);
        return service.save(faculty);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
