package com.blue.alumniMangePortal.dto;

import com.blue.alumniMangePortal.entity.JobsAdvertised;
import com.blue.alumniMangePortal.entity.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentJob {
    private Student student;
    private JobsAdvertised jobsAdvertised;
}
