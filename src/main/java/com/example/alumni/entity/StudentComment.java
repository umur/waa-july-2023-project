package com.example.alumni.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.Objects;

@Entity
@Data
@Table(name = "studentcomment")
@SQLDelete(sql = "UPDATE StudentComment SET deleted = true WHERE id=?")
@FilterDef(name = "deletedStudentCommentFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedStudentCommentFilter", condition = "deleted = :isDeleted")
public class StudentComment extends BaseEntity {

    @Lob
    private String comment;

    @ManyToOne
    @JoinColumn
    private User faculty;

    @ManyToOne
    @JoinColumn
    private User student;
}
