package com.twohundred.alumni.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Student {
    @Id
    private Long id;

    private String major;

    private Double gpa;
    
    private Boolean deleted = Boolean.FALSE;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
