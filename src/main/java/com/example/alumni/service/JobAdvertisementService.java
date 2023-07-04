package com.example.alumni.service;

import com.example.alumni.entity.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService extends BaseService<JobAdvertisement, Long>{
    Iterable<JobAdvertisement> getByTags(List<String> tags);
}
