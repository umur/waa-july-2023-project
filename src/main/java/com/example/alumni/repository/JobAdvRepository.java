package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.JobAdv;
import java.util.List;
import com.example.alumni.entity.Tag;


public interface JobAdvRepository extends ListCrudRepository<JobAdv, Long> {
    Iterable<JobAdv> findByTagsIn(List<Tag> tags);
}
