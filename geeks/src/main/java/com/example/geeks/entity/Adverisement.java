package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class JobAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String title;
    private String state;
    private String city;
    private String tag;
    private LocalDate date;
    private LocalDate startDate;
    private double salary;
    private String description;
    private boolean isDeleted;

//    @ManyToMany(mappedBy = "jobsApplied")
//    private List<User> applicants;
//
//    @ManyToOne
//    private User creator;

    // Add constructors, getters, and setters
}

