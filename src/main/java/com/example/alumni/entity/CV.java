package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String careerGoal;
    private String jobTitle;

    @OneToMany
    @JoinColumn(name = "CV_id")
    private List<Experience> experiences;

    @ManyToMany
    @JoinTable
    private List<Tag> tags;
}
