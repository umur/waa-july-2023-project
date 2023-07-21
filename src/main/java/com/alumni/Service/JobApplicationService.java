package com.alumni.Service;

import com.alumni.entity.Comment;
import com.alumni.entity.JobApplication;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface JobApplicationService {
    List<JobApplication> getList(int page, int size, Long jobId, Long studentId);


    List<JobApplication> getByJob(Long jobId);

    void create(JobApplication record);

    JobApplication findById(Long id);

    void put(Long id, JobApplication record);

    void deleteById(Long id);

    void createFromJob(Long id, HttpServletRequest request);

    void addComment(Long id, Comment comment);

    List<Comment> getComments(Long id);
}
