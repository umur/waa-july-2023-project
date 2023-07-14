package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> filterJobAdsBySearchParam(String tag, String city, String state, String companyName);

}
