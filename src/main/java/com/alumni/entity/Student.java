package com.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String state;
    private String city;
    private String major;
    private String name;
    private String cvUrl;
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;

    @OneToOne
    private User user;


}
