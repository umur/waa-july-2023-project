package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.CV;

public interface CVRepository extends ListCrudRepository<CV, Long> {
}
