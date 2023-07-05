package com.blue.alumniMangePortal.dto;

import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentJob {
    private Student student;
    private JobsAdvertise jobsAdvertised;
}
