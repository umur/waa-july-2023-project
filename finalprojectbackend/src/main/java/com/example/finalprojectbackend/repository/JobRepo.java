package com.example.finalprojectbackend.repository;

import com.example.finalprojectbackend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Integer> {

}
