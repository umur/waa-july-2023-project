package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.JobAdv;

public interface JobAdvRepository extends ListCrudRepository<JobAdv, Long> {
}
