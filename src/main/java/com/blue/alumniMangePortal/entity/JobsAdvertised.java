package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class JobsAdvertised {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(value=TemporalType.DATE)
    private Date date;
    private String position;
//    private Address location;
    @ManyToOne
    @JsonBackReference
    private Student student;
}
