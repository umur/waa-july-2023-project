package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.Department;
import com.miu.waa.aluminimanagement.service.DepartmentService;
import com.miu.waa.aluminimanagement.service.DepartmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;
    @GetMapping()
    public List<Department> findAll(){
        return service.findAll();
    }
    @GetMapping("{id}")
    public Optional<Department> findById(@PathVariable Long id){
        return service.findById(id);

    }
    @PostMapping()
   public Department save(@RequestBody Department faculty){
        return service.save(faculty);
   }
    @PutMapping("{id}")
    public Department update(@PathVariable Long id, @RequestBody Department faculty){
        faculty.setId(id);
        return service.save(faculty);
    }
    @DeleteMapping("{id}")
    public void Delete(@PathVariable Long id){
        service.delete(id);
    }


}
