package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.Department;
import waa.miu.AlumniManagementPortal.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@CrossOrigin
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<Department> createAddress(@RequestBody Department department) {
        Department createDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDepartment);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        Department updateDepartment = departmentService.updateDepartment(department);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }


}
