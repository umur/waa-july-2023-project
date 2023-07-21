package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Data
@SQLDelete(sql = "UPDATE comment SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date commentedAt;
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "student_id")
    private User student;

    @OneToOne
    @JoinColumn(name = "faculty_id")
    private User faculty;
}
