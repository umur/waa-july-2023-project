package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.Job;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.Tag;
import com.twohundred.alumni.repository.JobRepo;
import com.twohundred.alumni.repository.StudentRepo;
import com.twohundred.alumni.repository.TagRepo;
import com.twohundred.alumni.service.EChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EChartServiceImpl implements EChartService {

    private final JobRepo jobRepo;
    private final StudentRepo studentRepo;
    private final TagRepo tagRepo;

    @Override
    public Map<String, Long> numberOfJobsPerLocation() {
        List<Job> jobs = jobRepo.findAll();
        return jobs.stream().collect(Collectors.groupingBy((Job job) -> job.getAddress().getZip(),
                Collectors.counting()));
    }

    @Override
    public Map<String, Long> numberOfStudentsPerState() {
        List<Student> students = studentRepo.findAll();
        return students.stream().collect(
                Collectors.groupingBy((Student student) -> student.getUser().getAddress().getState(),
                        Collectors.counting()));

    }

    @Override
    public Map<String, Long> numberOfStudentsPerCity() {
        List<Student> students = studentRepo.findAll();
        return students.stream().collect(
                Collectors.groupingBy((Student student) -> student.getUser().getAddress().getCity(),
                        Collectors.counting()));
    }

    @Override
    public List<String> getAllTags() {
        return tagRepo.findAll().stream().map(Tag::getName).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<String>> tagsWithLocation() {
        List<Job> jobs = jobRepo.findAll();
        Map<String, List<String>> result = new HashMap<>();
        jobs.forEach(job  -> {
            if(result.get(job.getAddress().getZip()) == null) {
                result.put(job.getAddress().getZip(), new ArrayList<String>());
            }
            List<String> list = result.get(job.getAddress().getZip());
            list.addAll(job.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
            result.put(job.getAddress().getZip(), list);
        });
        return result;
    }

    @Override
    public Map<String, Long> averageTimeSpentToFindJobPerGPARange() {
        return null;
    }
}
