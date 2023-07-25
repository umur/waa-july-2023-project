package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.Department;
import waa.miu.AlumniManagementPortal.repository.DepartmentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepo departmentRepo;

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with id "+id+" not found"));
    }

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public void deleteDepartment(Long id){
        if (!departmentRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with id "+id+" not found");
        }
        departmentRepo.deleteById(id);
    }

    public Department updateDepartment(Department department){
        if (!departmentRepo.existsById(department.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with id "+department.getId()+" not found");
        }
        return departmentRepo.save(department);
    }

    public Department createDepartment(Department department){
        return departmentRepo.save(department);
    }

}
