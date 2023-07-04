package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CV_id;

    private String career_goal;
    private String job_title;

    @OneToMany
    @JoinColumn(name = "CV_id")
    private List<Experience> experiences;

    @ManyToMany
    @JoinTable(name = "CV_Tag", joinColumns = @JoinColumn(name = "CV_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
