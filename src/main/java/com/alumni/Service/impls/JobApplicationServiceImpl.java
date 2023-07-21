package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.JobApplicationService;
import com.alumni.Service.JwtService;
import com.alumni.Service.StudentService;
import com.alumni.entity.Comment;
import com.alumni.entity.JobAdvertisement;
import com.alumni.entity.JobApplication;
import com.alumni.entity.Student;
import com.alumni.repository.CommentRepository;
import com.alumni.repository.JobApplicationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final ModelMapper modelMapper;
    private  final JwtService jwtService;
    private final StudentService studentService;
    private final CommentRepository commentRepository;

    @Autowired
    private final JobApplicationRepository repository;

    @Override
    public List<JobApplication> getList(int page, int size, Long jobId, Long studentId) {
        return repository.findAll(PageRequest.of(page, size)).stream()
                .map((JobApplication jobApplication) -> modelMapper.map(jobApplication, JobApplication.class))
                .collect(Collectors.toList());
    }

    public List<JobApplication> getByJob( Long jobId) {
        return repository.findAllByJobAdvertisementId(jobId).stream()
                .map((JobApplication jobApplication) -> modelMapper.map(jobApplication, JobApplication.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(JobApplication record) {
        repository.save(record);
    }

    @Override
    public JobApplication findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Job Application with ID: " + id + " was not found"));
    }

    @Override
    public void put(Long id, JobApplication record) {
        JobApplication source = findById(id);
        record.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void createFromJob(Long id, HttpServletRequest request) {
        JobApplication j= new JobApplication();
        JobAdvertisement jobAdvertisement= new JobAdvertisement();
        jobAdvertisement.setId(id);

        final String authorizationHeader = request.getHeader("Authorization");

        Student student=studentService.findByUserName( jwtService.extractUserName(authorizationHeader));
        j.setStudent(student);
        j.setJobAdvertisement(jobAdvertisement);

        repository.save(j);
    }

    @Override
    public void addComment(Long id, Comment comment) {

    }

    @Override
    public List<Comment> getComments(Long id) {
        return null;
    }
}
