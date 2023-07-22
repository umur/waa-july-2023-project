package com.twohundred.alumni.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.Tag;
import com.twohundred.alumni.entity.dto.request.JobAdDtoWithCV;
import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.exception.Exceptions;
import com.twohundred.alumni.repository.JobAdvertisementRepo;
import com.twohundred.alumni.repository.TagRepo;
import com.twohundred.alumni.service.JobAdvertisementService;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobAdvertisementServiceImpl implements JobAdvertisementService {
    private final ModelMapper modelMapper;
    private final SecurityUtil securityUtil;
    private final StudentServiceImpl studentServiceImpl;
    private final TagRepo tagRepo;
    private final JobAdvertisementRepo jobAdvertisementRepo;

    @Override
    public List<JobAdvertisement> filterJobAdsBySearchParam(String tag, String city, String state, String companyName) {
        if (isNotEmpty(tag)) {
            List<Tag> tags = tagRepo.findAllByNameLike(tag);
            return jobAdvertisementRepo.findAllByTagsIn(tags);
        } else if (isNotEmpty(city))
            return jobAdvertisementRepo.findAllByCityLike(city);
        else if (isNotEmpty(state))
            return jobAdvertisementRepo.findAllByStateLike(state);
        else if (isNotEmpty(companyName))
            return jobAdvertisementRepo.findAllByCompanyNameLike(companyName);
        else
            return jobAdvertisementRepo.findAll();
    }

    private boolean isNotEmpty(@Nullable Object str) {
        return str != null && !"".equals(str);
    }
    
    @Override
    public List<JobAdvertisementDto> getAll() {
        List<JobAdvertisement> jobAds = jobAdvertisementRepo.findAll();
        return jobAds.stream().map(j -> modelMapper.map(j, JobAdvertisementDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<JobAdDtoWithCV> getCreatedJobAds(Long userId) {
        List<JobAdvertisement> jobAds = jobAdvertisementRepo.findAllByCreatedStudentId(userId);

        return jobAds.stream().map(j -> modelMapper.map(j, JobAdDtoWithCV.class)).collect(Collectors.toList());
    }

    @Override
    public JobAdvertisementDto create(JobAdvertisementDto jobAdvertisementDto, Long userId) {
        Student student = studentServiceImpl.findById(userId);
        JobAdvertisement jobAd = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);
        jobAd.setCreatedStudent(student);
        jobAd.setDateCreated(new Date());
        JobAdvertisement tempJobAd = jobAdvertisementRepo.save(jobAd);

        return modelMapper.map(tempJobAd, JobAdvertisementDto.class);
    }

    @Override
    public JobAdvertisementDto update(JobAdvertisementDto jobAdvertisementDto, Long userId) {
        JobAdvertisement jobAdvertisement = findByIdAndCreatedUser(jobAdvertisementDto.getId(), userId);
        JobAdvertisement tempJobAdvertisement = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);

        jobAdvertisement.setDescription(tempJobAdvertisement.getDescription());
        jobAdvertisement.setBenefits(tempJobAdvertisement.getBenefits());
        jobAdvertisement.setCompanyName(tempJobAdvertisement.getCompanyName());
        jobAdvertisement.setState(tempJobAdvertisement.getState());
        jobAdvertisement.setCity(tempJobAdvertisement.getCity());
        jobAdvertisement.setTags(tempJobAdvertisement.getTags());
        jobAdvertisement.setFiles(tempJobAdvertisement.getFiles());

        JobAdvertisement temp = jobAdvertisementRepo.save(jobAdvertisement);
        return modelMapper.map(temp, JobAdvertisementDto.class);
    }

    @Override
    public JobAdvertisementDto delete(int id, Long userId) {
        JobAdvertisement jobAdvertisement = findByIdAndCreatedUser(id, userId);
        jobAdvertisement.setDeleted(true);

        JobAdvertisement temp = jobAdvertisementRepo.save(jobAdvertisement);
        return modelMapper.map(temp, JobAdvertisementDto.class);
    }

    @Override
    public JobAdvertisement findByIdAndCreatedUser(int id, Long userId) {
        JobAdvertisement jobAd = getById(id);

        if (!jobAd.getCreatedStudent().getId().equals(userId)) {
            throw Exceptions.UNAUTHORIZED;
        }

        return jobAd;
    }

    @Override
    public JobAdvertisement getById(int id) {
        Optional<JobAdvertisement> optionalJobAd = jobAdvertisementRepo.findById(id);

        if (!optionalJobAd.isPresent()) {
            throw Exceptions.JOB_AD_NOT_FOUND;
        }

        return optionalJobAd.get();
    }
    
    @Override
    public JobAdvertisementDto getByIdDto(int id) {
        JobAdvertisement jobAd = getById(id);

        return modelMapper.map(jobAd, JobAdvertisementDto.class);
    }
    @Override
    public JobAdDtoWithCV getByIdDtoWithCV(int id) {
        JobAdvertisement jobAd = getById(id);

        if (!securityUtil.getCurrentUserId().equals(jobAd.getCreatedStudent().getId())) {
            jobAd.setCvs(null);
        }

        return modelMapper.map(jobAd, JobAdDtoWithCV.class);
    }
}
