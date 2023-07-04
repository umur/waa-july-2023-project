package com.example.alumni.service;

import com.example.alumni.entity.JobAdvertisement;
import com.example.alumni.entity.dto.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService extends BaseService<JobAdvertisementDto, Long>{
    Iterable<JobAdvertisementDto> getByTags(List<String> tags);
}
