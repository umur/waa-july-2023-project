package com.miu.waa.aluminimanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1000)
    private String description;
    private String jobTitle;
    private String jobType;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
    private boolean isDeleted = false;

    @OneToMany(mappedBy = "job")
    @JsonBackReference(value = "job-jobApplication")
    private List<JobApplication> jobApplications;

    @ManyToMany()
    private List<Tag> tags;
}

