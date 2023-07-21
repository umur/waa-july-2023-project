package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Faculty faculty;
    private boolean isDeleted = false;
}

