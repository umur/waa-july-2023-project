package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Faculty;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> findAll();
    Optional<Faculty> findById(Long id);
//
    Faculty save(Faculty faculty);
    void delete(Long id);


}
