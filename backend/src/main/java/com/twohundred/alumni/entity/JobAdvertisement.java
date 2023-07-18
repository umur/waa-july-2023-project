package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tag SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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
    private Student createdStudent;

    @ElementCollection
    private List<String> files;

    @CreatedDate
    private Date dateCreated;
    private Boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "jobAd")
    private List<CV> cvs;
}
