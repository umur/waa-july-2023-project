package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Student {
    @Id
    private Long id;

    private String major;

    private Double gpa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User student;
}
