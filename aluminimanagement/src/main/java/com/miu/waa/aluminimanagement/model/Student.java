package com.miu.waa.aluminimanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("student")
public class Student extends  Person{
    private String major;
    private int graduatedYear;
    private int universityId;
    private double gpa;

    @OneToMany(mappedBy = "student")
    @JsonBackReference(value = "student-jobApplication")
    private List<JobApplication> jobApplications;
}
