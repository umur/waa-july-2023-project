package com.alumni.repository;

import com.alumni.entity.Admin;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {



    List<Admin> findAllByNameContainsIgnoreCaseOrderByIdDesc(String name, PageRequest of);
}
