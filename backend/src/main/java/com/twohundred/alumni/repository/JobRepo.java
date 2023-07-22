package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Job;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends ListCrudRepository<Job, Long> {
}
