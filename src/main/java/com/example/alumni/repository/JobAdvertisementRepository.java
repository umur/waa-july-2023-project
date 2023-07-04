package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.JobAdvertisement;
import java.util.List;
import com.example.alumni.entity.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepository extends ListCrudRepository<JobAdvertisement, Long> {
    Iterable<JobAdvertisement> findByTagsIn(List<Tag> tags);
}
