package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Tag;
import com.twohundred.alumni.repository.JobAdvertisementRepo;
import com.twohundred.alumni.repository.TagRepo;
import com.twohundred.alumni.service.JobAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final TagRepo tagRepo;
    private final JobAdvertisementRepo jobAdvertisementRepo;

    @Override
    public List<JobAdvertisement> filterJobAdsBySearchParam(String tag, String city, String state, String companyName) {
        if (isNotEmpty(tag)) {
            List<Tag> tags = tagRepo.findAllByNameLike(tag);
            return jobAdvertisementRepo.findAllByTagsIn(tags);
        } else if (isNotEmpty(city)) return jobAdvertisementRepo.findAllByCityLike(city);
        else if (isNotEmpty(state)) return jobAdvertisementRepo.findAllByStateLike(state);
        else if (isNotEmpty(companyName)) return jobAdvertisementRepo.findAllByCompanyNameLike(companyName);
        else return jobAdvertisementRepo.findAll();
    }

    private boolean isNotEmpty(@Nullable Object str) {
        return str != null && !"".equals(str);
    }
}
