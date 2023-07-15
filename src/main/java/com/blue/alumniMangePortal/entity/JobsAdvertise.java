package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
//@Tag("JobsAdvertise")
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
    private String tag;
//    @ManyToOne
//    @JsonBackReference
//    private Student student;
    @OneToOne
    private Address address;

    @JsonIgnore
    boolean isDeleted;
//    @Tag("Software Development")

}