package com.twohundred.alumni.service;

import java.util.List;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.dto.request.JobAdDtoWithCV;
import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;

public interface JobAdvertisementService {

    JobAdvertisement getById(int id);

    JobAdvertisementDto getByIdDto(int id);

    List<JobAdDtoWithCV> getCreatedJobAds(Long userId);

    List<JobAdvertisementDto> getAll();

    List<JobAdvertisement> filterJobAdsBySearchParam(String tag, String city, String state, String companyName);

    JobAdvertisementDto create(JobAdvertisementDto jobAdvertisementDto, Long userId);

    JobAdvertisement findByIdAndCreatedUser(int id, Long userId);

    JobAdvertisementDto update(JobAdvertisementDto jobAdvertisementDto, Long userId);

    JobAdvertisementDto delete(int id, Long userId);

    JobAdDtoWithCV getByIdDtoWithCV(int id);
}
