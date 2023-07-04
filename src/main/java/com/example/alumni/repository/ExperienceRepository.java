package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Experience;

public interface ExperienceRepository extends ListCrudRepository<Experience, Long> {
}
