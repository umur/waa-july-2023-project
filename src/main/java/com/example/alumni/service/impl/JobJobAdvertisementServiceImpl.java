package com.example.alumni.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.alumni.repository.TagRepository;
import com.example.alumni.service.JobJobAdvertisementService;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.entity.Tag;
import com.example.alumni.repository.JobAdvertisementRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class JobJobAdvertisementServiceImpl implements JobJobAdvertisementService {

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    private TagRepository tagRepository;

//    @Autowired
//    private EntityManager entityManager;


    @Override
    public Iterable<JobAdvertisement> getAllJobAdvs() {

        return jobAdvertisementRepository.findAll();
    }

//    @Override
//    public Iterable<JobAdvertisement> getAll(boolean isDeleted) {
//
//        Session session = entityManager.unwrap(Session.class);
//        Filter filter = session.enableFilter("deletedJobAdvertisementFilter");
//        filter.setParameter("isDeleted", isDeleted);
//        Iterable<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.findAll();
//        session.disableFilter("deletedJobAdvertisementFilter");
//        return jobAdvertisements;
//    }

    @Override
    public JobAdvertisement getJobAdvById(long id) {
        return jobAdvertisementRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<JobAdvertisement> getJobAdvByTags(List<String> tags) {
        List<Tag> filterTags = new ArrayList<>();
        for (String tagName : tags) {
            Optional<Tag> tag = tagRepository.findByName(tagName);
            if (tag.isPresent()) {
                filterTags.add(tag.get());
            }
        }
        return jobAdvertisementRepository.findByTagsIn(filterTags);
    }

    @Override
    public JobAdvertisement createJobAdv(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public Pair<Boolean, JobAdvertisement> updateJobAdv(JobAdvertisement jobAdvertisement) {
        boolean exists = jobAdvertisementRepository.existsById(jobAdvertisement.getId());
        jobAdvertisementRepository.save(jobAdvertisement);
        return Pair.of(exists, jobAdvertisement);
    }

    @Override
    public boolean deleteJobAdv(long id) {
        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(id).orElse(null);
        if (existingJobAdvertisement != null) {
            jobAdvertisementRepository.delete(existingJobAdvertisement);
            return true;
        }
        return false;
    }
}
