package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;
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
       return repository.save(faculty);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
