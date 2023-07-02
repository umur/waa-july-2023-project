package com.miu.waa.aluminimanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("student")
public class Student extends  Person{

    @OneToOne
    @JoinColumn(name="Department_ID")
    private Department department;
    private Double gpa;

    @ManyToMany(mappedBy = "applied", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobAdvertisement> appliedTo;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> comments;

}
