package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private boolean isDeleted;
    private boolean currentlyEmployed;
    private String jobExperiences;
//    private Address address;
//    private Tag tag;
//    private Major major;
    @OneToMany
   // @JsonManagedReference
    private List<JobsAdvertise> jobsAdvertisedList=new ArrayList<>();
//    private CurrentWorkPlace;
//    private Cv cv;

}
