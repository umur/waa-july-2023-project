package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends AlumniUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//    private String email;
//    private String firstName;
//    private String lastName;
//    private String password;
    private String phoneNumber;
    @JsonIgnoreProperties
    private boolean isDeleted;
    private boolean currentlyEmployed;
    @OneToOne
    private JobExperience jobExperiences;
    @OneToOne
    private Address address;
//    private Tag tag;
    @ManyToOne
    private Major major;
    @OneToMany
//    @JsonManagedReference
    private List<JobsAdvertise> jobsAdvertisedList=new ArrayList<>();
//    private CurrentWorkPlace;
    @OneToOne
    private UploadedFilePath cv;

}
