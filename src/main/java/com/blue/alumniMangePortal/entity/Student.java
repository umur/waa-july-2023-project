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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private JobExperience jobExperiences;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private Address address;
//    private Tag tag;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private Major major;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
//    @JsonManagedReference
    private List<JobsAdvertise> jobsAdvertisedList=new ArrayList<>();
//    private CurrentWorkPlace;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private UploadedFilePath cv;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private List<JobsApplied> jobsAppliedList;

}
