package com.example.alumni.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.alumni.entity.dto.JobAdvertisementDto;
import com.example.alumni.repository.TagRepository;
import com.example.alumni.service.JobAdvertisementService;
import com.example.alumni.util.CurrentUserUtil;
import com.example.alumni.util.ListMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.entity.Tag;
import com.example.alumni.repository.JobAdvertisementRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
@AllArgsConstructor
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;

    private final TagRepository tagRepository;

    private final CurrentUserUtil currentUserUtil;

    private final ModelMapper modelMapper;

    private final ListMapper<JobAdvertisement, JobAdvertisementDto> listMapper;

//    @PersistenceContext
//    private EntityManager entityManager;


    @Override
    public Iterable<JobAdvertisementDto> getAll() {
        List<JobAdvertisementDto> jobs = listMapper.mapList(jobAdvertisementRepository.findAll(),
                new JobAdvertisementDto());

        return jobs;
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
    public JobAdvertisementDto getById(Long id) {
        Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementRepository.findById(id);
        if (jobAdvertisement.isPresent()) {
            return modelMapper.map(jobAdvertisement.get(), JobAdvertisementDto.class);
        }

        return null;
    }

    @Override
    public Iterable<JobAdvertisementDto> getAllByTags(List<String> tags) {
        List<Tag> filterTags = new ArrayList<>();
        for (String tagName : tags) {
            Optional<Tag> tag = tagRepository.findByName(tagName);
            if (tag.isPresent()) {
                filterTags.add(tag.get());
            }
        }
        return listMapper.mapList(jobAdvertisementRepository.findAllByTagsIn(filterTags),
                new JobAdvertisementDto());

    }

    @Override
    public Iterable<JobAdvertisementDto> getAllByCity(String city) {
        return listMapper.mapList(jobAdvertisementRepository.findAllByCity(city),
                new JobAdvertisementDto());
    }

    @Override
    public Iterable<JobAdvertisementDto> getAllByState(String state) {
        return listMapper.mapList(jobAdvertisementRepository.findAllByState(state),
                new JobAdvertisementDto());
    }

    @Override
    public Iterable<JobAdvertisementDto> getAllByCompany(String company) {
        return listMapper.mapList(jobAdvertisementRepository.findAllByCompany(company),
                new JobAdvertisementDto());
    }

    @Override
    public JobAdvertisementDto add(JobAdvertisementDto jobAdvertisementdto) {

        JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementdto, JobAdvertisement.class);
        jobAdvertisement.setUser(currentUserUtil.getUser().get());
        jobAdvertisement = jobAdvertisementRepository.save(jobAdvertisement);

        return modelMapper.map(jobAdvertisement, JobAdvertisementDto.class);
    }

    @Override
    public Pair<Boolean, JobAdvertisementDto> update(JobAdvertisementDto jobAdvertisementDto) throws IllegalAccessException {
        JobAdvertisement jobAdvertisementForUpdate;
        Optional<JobAdvertisement> existingJobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementDto.getId());
        if (existingJobAdvertisement.isPresent()) {
            jobAdvertisementForUpdate = existingJobAdvertisement.get();
            if (currentUserUtil.getUserId().get() != jobAdvertisementForUpdate.getUser().getId()) {
                throw new IllegalAccessException("Only owner can edit");
            }
        } else {
            jobAdvertisementForUpdate = new JobAdvertisement();
        }

        jobAdvertisementForUpdate = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);

        jobAdvertisementForUpdate.setUser(currentUserUtil.getUser().get());

        jobAdvertisementForUpdate = jobAdvertisementRepository.save(jobAdvertisementForUpdate);

        jobAdvertisementDto = modelMapper.map(jobAdvertisementForUpdate, JobAdvertisementDto.class);

        return Pair.of(existingJobAdvertisement.isPresent(), jobAdvertisementDto);
    }

    @Override
    public boolean delete(Long id) throws IllegalAccessException {
        JobAdvertisement existingJobAdvertisement = jobAdvertisementRepository.findById(id).orElse(null);
        if (existingJobAdvertisement != null) {
            if (currentUserUtil.getUserId().get() != existingJobAdvertisement.getUser().getId()) {
                throw new IllegalAccessException("Only owner can edit");
            }
            jobAdvertisementRepository.delete(existingJobAdvertisement);
            return true;
        }
        return false;
    }
}
