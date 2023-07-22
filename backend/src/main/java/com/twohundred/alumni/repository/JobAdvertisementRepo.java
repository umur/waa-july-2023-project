package com.twohundred.alumni.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Tag;

public interface JobAdvertisementRepo extends ListCrudRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByTagsIn(List<Tag> tags);

    List<JobAdvertisement> findAllByStateLike(String state);

    List<JobAdvertisement> findAllByCityLike(String city);

    List<JobAdvertisement> findAllByCompanyNameLike(String name);

    List<JobAdvertisement> findAllByCreatedStudentId(Long id);
}
