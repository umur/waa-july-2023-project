package com.twohundred.alumni.service;

import java.util.List;
import java.util.Map;

public interface EChartService {
    Map<String, Long> numberOfJobsPerLocation();
    Map<String, Long> numberOfStudentsPerState();
    Map<String, Long> numberOfStudentsPerCity();

    List<String> getAllTags();

    Map<String, List<String>> tagsWithLocation();

    Map<String, Long> averageTimeSpentToFindJobPerGPARange();


}
