package com.blue.alumniMangePortal.service;

import java.util.List;
import java.util.Map;

public interface GraphService {
   List< Map<String, Integer>> getNumberStudentsPerCity();
   List<Map<String, Integer>> getNumberStudentsPerState();
   List<Map<String, Integer>> getJobsAdvertisePerState();
//   List<Map<String, Integer>> getTagsPerState();
}
