package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Advertisement {
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

    // navigation properties
    @ManyToOne
    @JoinColumn
    private User creator;

//    @OneToMany(mappedBy = "student")
//    private List<User> applicants;



}
