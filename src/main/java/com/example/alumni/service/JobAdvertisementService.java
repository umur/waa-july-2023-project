package com.example.alumni.service;

import com.example.alumni.entity.dto.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService extends BaseService<JobAdvertisementDto, Long>{
    Iterable<JobAdvertisementDto> getAllByTags(List<String> tags);

    Iterable<JobAdvertisementDto> getAllByCity(String city);

    Iterable<JobAdvertisementDto> getAllByState(String state);

    Iterable<JobAdvertisementDto> getAllByCompany(String company);
}
