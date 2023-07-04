package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Department;
import com.blue.alumniMangePortal.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @PostMapping
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
