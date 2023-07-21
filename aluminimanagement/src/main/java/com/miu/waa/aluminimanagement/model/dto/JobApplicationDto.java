package com.miu.waa.aluminimanagement.model.dto;

import com.miu.waa.aluminimanagement.model.JobApplicationId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobApplicationDto {
    private JobApplicationId id;
    private JobDto job;
    private StudentDto student;
    private LocalDateTime appliedDate;
}
