package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE Resume SET deleted = true WHERE id=?")
@FilterDef(name = "deletedResumeFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedResumeFilter", condition = "deleted = :isDeleted")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String careerGoal;
    private String jobTitle;

    @OneToMany
    @JoinColumn
    private List<Resume> Resumes;

    @ManyToMany
    @JoinTable
    private List<Tag> tags;

    @OneToOne
    private User user;

    private boolean deleted = Boolean.FALSE;
}
