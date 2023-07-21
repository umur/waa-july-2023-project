package com.miu.waa.aluminimanagement.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobType;
    private String jobPosition;
    private String jobDescription;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
    private Date startDate;
    private Date endDate;
    private boolean isDeleted = false;
}
