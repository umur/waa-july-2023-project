package com.blue.alumniMangePortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class JobsApplied {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToOne
    private JobsAdvertise jobsAdvertiseList;
    @ManyToOne
    private Student student;
}
