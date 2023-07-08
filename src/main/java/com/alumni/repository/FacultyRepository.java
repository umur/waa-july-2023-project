package com.alumni.repository;

import com.alumni.entity.Faculty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {


    List<Faculty> findAllByNameContainsIgnoreCaseOrderByIdDesc(String name, Pageable of);
}
