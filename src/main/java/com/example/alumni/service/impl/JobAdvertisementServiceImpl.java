package com.example.alumni.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.alumni.repository.TagRepository;
import com.example.alumni.service.JobAdvertisementService;
import com.example.alumni.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.entity.Tag;
import com.example.alumni.repository.JobAdvertisementRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CurrentUserUtil currentUserUtil;

//    @PersistenceContext
//    private EntityManager entityManager;


    @Override
    public Iterable<JobAdvertisement> getAll() {

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
    public JobAdvertisement getById(Long id) {
        return jobAdvertisementRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<JobAdvertisement> getByTags(List<String> tags) {
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
    public JobAdvertisement add(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public Pair<Boolean, JobAdvertisement> update(JobAdvertisement jobAdvertisement) throws IllegalAccessException {
        boolean exists = jobAdvertisementRepository.existsById(jobAdvertisement.getId());
        if (exists) {
            JobAdvertisement existingJob = jobAdvertisementRepository.findById(jobAdvertisement.getId()).get();
            if (currentUserUtil.getUserId().get() != existingJob.getUser().getId()) {
                throw new IllegalAccessException("Only owner can edit");
            }
            jobAdvertisementRepository.save(jobAdvertisement);
        }

        return Pair.of(exists, jobAdvertisement);
    }

    @Override
    public boolean delete(Long id) {
        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(id).orElse(null);
        if (existingJobAdvertisement != null) {
            jobAdvertisementRepository.delete(existingJobAdvertisement);
            return true;
        }
        return false;
    }
}
