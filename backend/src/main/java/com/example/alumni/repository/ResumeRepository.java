package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Resume;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ListCrudRepository<Resume, Long> {
}
