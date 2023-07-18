package com.twohundred.alumni.entity;

import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student extends User {

    private String major;

    private Double gpa;

    @OneToMany(mappedBy = "student")
    private List<CV> cvs;
}
