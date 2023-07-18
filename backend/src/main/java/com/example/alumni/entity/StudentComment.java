package com.example.alumni.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "studentcomment")
@SQLDelete(sql = "UPDATE StudentComment SET deleted = true WHERE id=?")
@FilterDef(name = "deletedStudentCommentFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedStudentCommentFilter", condition = "deleted = :isDeleted")
public class StudentComment implements Serializable {

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

    @Column(columnDefinition="TEXT")
    private String comment;

    @ManyToOne
    @JoinColumn
    private User faculty;

    @ManyToOne
    @JoinColumn
    private User student;
}
