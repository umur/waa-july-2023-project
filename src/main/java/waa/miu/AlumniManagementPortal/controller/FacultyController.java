package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;
import waa.miu.AlumniManagementPortal.entity.Faculty;
import waa.miu.AlumniManagementPortal.service.FacultyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public List<Faculty> findAll(){
        return facultyService.findAll();
    }

    @GetMapping("/{id}")
    public Faculty findById(@PathVariable Long id){
        return facultyService.findById(id);
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        facultyService.delete(id);
    }

}
