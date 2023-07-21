package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.helper.EmailService;
import com.miu.waa.aluminimanagement.model.Job;
import com.miu.waa.aluminimanagement.model.JobApplication;
import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.model.Tag;
import com.miu.waa.aluminimanagement.model.dto.JobApplicationDto;
import com.miu.waa.aluminimanagement.model.dto.JobCount;
import com.miu.waa.aluminimanagement.model.dto.JobDto;
import com.miu.waa.aluminimanagement.model.dto.JobSimpleDto;
import com.miu.waa.aluminimanagement.repository.JobApplicationRepo;
import com.miu.waa.aluminimanagement.repository.JobRepo;
import com.miu.waa.aluminimanagement.repository.StudentRepository;
import com.miu.waa.aluminimanagement.repository.TagRepo;
import com.miu.waa.aluminimanagement.security.MyUserDetails;
import com.miu.waa.aluminimanagement.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final ModelMapper modelMapper;
    private final JobRepo jobRepo;
    private final JobApplicationRepo jobApplicationRepo;
    private final TagRepo tagRepo;
    private final StudentRepository studentRepo;
    private final JavaMailSender javaMailSender;



    @Override
    public List<JobSimpleDto> findAll(String filter, String value) {
        List<Job> jobs;
        switch (filter.toLowerCase()) {
            case "tags":
                jobs = jobRepo.findJobsByTags_TagEquals(value);
                break;
            case "state":
                jobs = jobRepo.findByAddress_StateIgnoreCase(value);
                break;
            case "city":
                System.out.println(value);
                var state_city = value.split(".");
                jobs = jobRepo.findByAddress_StateIgnoreCaseAndAddress_CityContainingIgnoreCase(state_city[0], state_city[1]);
                break;
            case "companyname":
                jobs = jobRepo.findByCompany_NameContainingIgnoreCase(value);
                break;
            default:
                jobs = jobRepo.findAll();
                break;
        }
        return getDtoList(jobs);
    }

    @Override
    public List<JobSimpleDto> findMyJobs() {
        List<Job> jobs;
        System.out.println();
        int studentId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        jobs = jobRepo.findByStudent_Id(studentId);
        return getDtoList(jobs);
    }

    @Override
    public JobDto addJob(JobDto job) {
        int studentId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        Student student = new Student();
        student.setId(studentId);
        try {
            Job job1 = modelMapper.map(job, Job.class);
            job1.setStudent(student);
            job1 = jobRepo.save(job1);
            return modelMapper.map(job1, JobDto.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public JobDto updateJob(int id, JobDto job) {
        Job job1 = jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job Not found"));
        job1 = modelMapper.map(job, Job.class);
        job1.setId(id);
        jobRepo.save(job1);
        return modelMapper.map(job1, JobDto.class);
    }

    @Override
    public void deleteJob(int id) {
        Job job = jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job Not Found"));
        job.setDeleted(true);
        jobRepo.save(job);
    }

    @Override
    public JobDto findById(int id) {
        Job job = jobRepo.findById(id)
                .filter(job1 -> !job1.isDeleted()).orElseThrow(() -> new RuntimeException("Job Not found"));
        return modelMapper.map(job, JobDto.class);
    }

    @Override
    public List<JobSimpleDto> getLastTenJobs() {
        Page<Job> page = jobRepo.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));
        return getDtoList(page.stream().toList());
    }

    @Override
    public List<JobApplication> getLastTenAppliedJobs() {
        Page<JobApplication> page = jobApplicationRepo.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "appliedDate")));
        return page.stream().toList();
    }

    @Override
    public List<Tag> findTagsByTag(String filter) {
        return tagRepo.findTagsByTagStartingWithIgnoreCase(filter);
    }
    @Override
    public List<JobApplicationDto> myJobApplications() {
        int studentId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        List<JobApplication> jobApplications = jobApplicationRepo.findByStudent_Id(studentId);
        return jobApplications.stream().map(ja->modelMapper.map(ja, JobApplicationDto.class)).toList();
    }



    @Override
    public String sendJobApplicationEmail(String recipient, String status) {
        EmailService emailService = new EmailService(javaMailSender);
        return emailService.sendEmail(recipient,"Job Application Submitted!!",status);
    }

    @Override
    public String sendJobApplicationNotificationEmail(String recipient, String status) {
        EmailService emailService = new EmailService(javaMailSender);
        return emailService.sendEmail(recipient,"New Job Application Submitted!!",status);
    }

    @Override
    public JobApplication applyJob(int jobId, int studentId) {
        Student student = new Student();
        Job job = new Job();
        try {
            job.setId(jobId);
            student.setId(studentId);
            JobApplication jobApplication = new JobApplication();
            jobApplication.setJob(job);
            jobApplication.setStudent(student);
            jobApplicationRepo.save(jobApplication);
            return jobApplication;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    private List<JobSimpleDto> getDtoList(List<Job> jobs) {
        return jobs.stream().map(this::getDto).toList();
    }
    private JobSimpleDto getDto(Job job) {
        return modelMapper.map(job, JobSimpleDto.class);
    }
    @Override
    public List<JobCount> noOfJobsPerLocation() {
        //       return getDtoList(jobRepo.count);
        return jobRepo.noOfJobsPerAddress();
    }
}
