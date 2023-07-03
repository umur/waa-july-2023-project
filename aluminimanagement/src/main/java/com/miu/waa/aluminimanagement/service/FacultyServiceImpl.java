package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Department;
import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.model.Tag;
import com.miu.waa.aluminimanagement.repository.DepartmentRepository;
import com.miu.waa.aluminimanagement.repository.FacultyRepository;
import com.miu.waa.aluminimanagement.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;
    private final TagRepository tagRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Faculty> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Faculty> findById(Long id) {
        return repository.findById(id);
    }


    @Override
    public Faculty save(Faculty faculty) {
        List<Tag> tags = tagRepository.findAllById(faculty.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        faculty.setTags(tags);

        Department department = departmentRepository.findById(faculty.getDepartment().getId()).get();

        faculty.setDepartment(department);

        return repository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
