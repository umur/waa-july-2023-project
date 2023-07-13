package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Resume extends BaseEntity {

    @Lob
    private String careerGoal;
    private String jobTitle;

    @OneToMany
    @JoinColumn
    private List<Experience> experiences;

    @ManyToMany
    @JoinTable
    private List<Tag> tags;

    @OneToOne
    private User user;

}
