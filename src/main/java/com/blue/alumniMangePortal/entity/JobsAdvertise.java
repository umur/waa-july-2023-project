package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class JobsAdvertise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(value=TemporalType.DATE)
    private Date date;
    private String position;
    @Temporal(value=TemporalType.DATE)
    private Date jobAppliedDate;
    private String companyName;
    @ManyToOne
    //@JsonBackReference
    private Student student;
    @OneToOne
    private Address address;
    @OneToMany
    List<Tag> tags;
    @JsonIgnore
    boolean isDeleted;
}