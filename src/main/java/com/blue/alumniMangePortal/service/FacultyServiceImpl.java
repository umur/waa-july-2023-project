package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.auth.RegisterRequest;
import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.repository.FacultyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepo facultyRepo;
    private final PasswordEncoder passwordEncoder;
    private final AddressService addressService;

    @Override
    public void addFaculty(RegisterRequest faculty) {

        Faculty newFaculty = new Faculty();
        newFaculty.setFirstName(faculty.getFirst_name());
        newFaculty.setLastName(faculty.getLast_name());
        newFaculty.setEmail(faculty.getEmail());
        newFaculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
        newFaculty.setRole(faculty.getRole());

        facultyRepo.save(newFaculty);
    }

    @Override
    public List<Faculty> getFaculties() {
        return facultyRepo.findAll();
    }

    @Override
    public Faculty getFaculty(Long id) {
        Optional<Faculty> facultyOptional = facultyRepo.findById(id);
        return facultyOptional.orElseThrow();
    }

    @Override
    public Faculty getFacultyByEmail(String email) {
        return facultyRepo.findByEmail(email).get();
    }

    @Override
    public void updateFaculty(Long id, Faculty faculty) {

        Address newAddress = addressService.saveAddress(faculty.getAddress());

        Faculty facultyToUpdate = getFaculty(id);
        facultyToUpdate.setFirstName(faculty.getFirstName());
        facultyToUpdate.setLastName(faculty.getLastName());
        facultyToUpdate.setEmail(facultyToUpdate.getEmail());
        facultyToUpdate.setPhone_number(faculty.getPhone_number());
        facultyToUpdate.setDepartment(faculty.getDepartment());
        facultyToUpdate.setTitle(faculty.getTitle());
        facultyToUpdate.setAddress(newAddress);
        facultyToUpdate.set_admin(faculty.is_admin());
        facultyToUpdate.set_deleted(faculty.is_deleted());
        facultyRepo.save(facultyToUpdate);
    }

    @Override
    public void deleteFaculty(Long id) {
        Faculty facultyToDelete = getFaculty(id);
        facultyToDelete.set_deleted(true);
        facultyRepo.save(facultyToDelete);
    }
}
