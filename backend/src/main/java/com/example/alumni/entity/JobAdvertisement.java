package com.example.alumni.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

@Entity
@Setter
@Getter
@Table(name="jobadvertisement")
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE JobAdvertisement SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobAdvertisementFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJobAdvertisementFilter", condition = "deleted = :isDeleted")
public class JobAdvertisement implements Serializable {

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

    private String positionTitle;
    @Lob
    private String Description;
    private Double minSalary;
    private Double maxSalary;
    @Lob
    private String requiredSkills;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn
    private User user;

    private String city;

    private String state;

    private String company;

    @OneToMany(mappedBy ="jobAdvertisement")
    @BatchSize(size = 20)
    private List<JobApplication> jobApplications;
}
