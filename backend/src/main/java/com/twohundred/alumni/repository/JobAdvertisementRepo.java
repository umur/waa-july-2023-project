package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepo extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByTagsIn(List<Tag> tags);

    List<JobAdvertisement> findAllByStateLike(String state);

    List<JobAdvertisement> findAllByCityLike(String city);

    List<JobAdvertisement> findAllByCompanyNameLike(String name);
}
