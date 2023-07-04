package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag_id;
    private String tag_name;


    @ManyToMany(mappedBy = "tags")
    private List<CV> cv;

}
