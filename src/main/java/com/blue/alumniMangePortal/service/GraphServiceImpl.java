package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GraphServiceImpl implements GraphService {
    private final StudentService studentService;
    private final JobsAdvertiseService jobsAdvertiseService;
//    @Override
//    public List<Map<String,Integer>> getNumberStudentsPerCity() {
//        Map<String, Integer> map = new HashMap<>();
//        List<Student> studentList = studentService.getAllStudents();
//
//        for (Student s : studentList) {
//            String city = s.getAddress().getCity();
//            if (map.get(city) == null) {
//                map.put(city, 1);
//            } else {
//                map.put(city, map.get(city) + 1);
//            }
//        }
//        System.out.println("============================");
//        System.out.println(List.of(map));
//        return Collections.singletonList(map);
//    }
//}
    @Override
public List<Map<String, Integer>> getNumberStudentsPerCity() {
    Map<String, Integer> map = new HashMap<>();
    List<Student> studentList = studentService.getAllStudents();

    // Count the number of students per city
    for (Student s : studentList) {
        String city = s.getAddress().getCity();
        map.put(city, map.getOrDefault(city, 0) + 1);
    }

    List<Map<String, Integer>> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        Map<String, Integer> cityCountMap = new HashMap<>();
        cityCountMap.put(entry.getKey(), entry.getValue());
        result.add(cityCountMap);
    }

    // Print the list of maps (optional for debugging)
    System.out.println("============================");
    System.out.println(result);

    return result;
}
@Override
    public List<Map<String, Integer>>getNumberStudentsPerState(){
        Map<String, Integer> map = new HashMap<>();
        List<Student> studentList = studentService.getAllStudents();

        // Count the number of students per city
        for (Student s : studentList) {
            String state = s.getAddress().getState();
            map.put(state, map.getOrDefault(state, 0) + 1);
        }

        List<Map<String, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Map<String, Integer> cityCountMap = new HashMap<>();
            cityCountMap.put(entry.getKey(), entry.getValue());
            result.add(cityCountMap);
        }

        // Print the list of maps (optional for debugging)
        System.out.println("============================");
        System.out.println(result);

        return result;
    }
    @Override
public List<Map<String, Integer>> getJobsAdvertisePerState(){
    Map<String, Integer> map = new HashMap<>();
    List<JobsAdvertise> jobsAdvertiseList = jobsAdvertiseService.getAll();

    // Count the number of students per city
    for (JobsAdvertise j : jobsAdvertiseList) {
        String state = j.getAddress().getState();
        map.put(state, map.getOrDefault(state, 0) + 1);
    }

    List<Map<String, Integer>> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        Map<String, Integer> stateCountMap = new HashMap<>();
        stateCountMap.put(entry.getKey(), entry.getValue());
        result.add(stateCountMap);
    }

    // Print the list of maps (optional for debugging)
    System.out.println("============================");
    System.out.println(result);

    return result;
}
//    public List<Map<String, Integer>> getTagsPerState(){
//        Map<String, Integer> map = new HashMap<>();
//        List<JobsAdvertise> jobsAdvertiseList = jobsAdvertiseService.getAll();
//
//        // Count the number of students per city
//        for (JobsAdvertise j : jobsAdvertiseList) {
//            String state = j.getAddress().getState();
//            map.put(state, map.getOrDefault(state, 0) + 1);
//        }
//
//        List<Map<String, Integer>> result = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            Map<String, Integer> stateCountMap = new HashMap<>();
//            stateCountMap.put(entry.getKey(), entry.getValue());
//            result.add(stateCountMap);
//        }
//
//        // Print the list of maps (optional for debugging)
//        System.out.println("============================");
//        System.out.println(result);
//
//        return result;
//    }
}
