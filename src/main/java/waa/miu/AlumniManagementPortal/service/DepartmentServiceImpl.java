package waa.miu.AlumniManagementPortal.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Department;
import waa.miu.AlumniManagementPortal.repository.DepartmentRepo;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    public DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo){
        this.departmentRepo=departmentRepo;
    }

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
    }

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public void deleteDepartment(Long id){
        if (!departmentRepo.existsById(id)) {
            throw new EntityNotFoundException("Address not found with id: " + id);
        }
        departmentRepo.deleteById(id);
    }

    public Department updateDepartment(Department department){
        if (!departmentRepo.existsById(department.getId())) {
            throw new EntityNotFoundException("Address not found with id: " + department.getId());
        }
        return departmentRepo.save(department);
    }

    public Department createDepartment(Department department){
        return departmentRepo.save(department);
    }

}
