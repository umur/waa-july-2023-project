package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@SQLDelete(sql = "UPDATE Resume SET deleted = true WHERE id=?")
@FilterDef(name = "deletedResumeFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedResumeFilter", condition = "deleted = :isDeleted")
public class Resume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Version
    private int version;

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
