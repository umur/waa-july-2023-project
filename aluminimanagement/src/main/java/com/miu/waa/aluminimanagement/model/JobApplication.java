package com.miu.waa.aluminimanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class JobApplication {
    @EmbeddedId
    private JobApplicationId id = new JobApplicationId();

    @ManyToOne
    @MapsId("jobId")
    @JsonManagedReference(value = "job-jobApplication")
    private Job job;

    @ManyToOne
    @MapsId("studentId")
    @JsonManagedReference(value = "student-jobApplication")
    private Student student;

    private LocalDateTime appliedDate = LocalDateTime.now();
}
