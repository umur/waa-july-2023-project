package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String benefits;
    private String companyName;
    private String state;
    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @ManyToOne
    private Faculty faculty;

    @ElementCollection
    private List<String> files;

    @CreatedDate
    private Date dateCreated;
    private boolean isDeleted = false;
}
