package com.example.alumni.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

@Entity
@Data
@Table(name="jobadvertisement")
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE JobAdvertisement SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobAdvertisementFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJobAdvertisementFilter", condition = "deleted = :isDeleted")
public class JobAdvertisement extends BaseEntity {

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

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

    private String city;

    private String state;

    private String company;

    @OneToMany(mappedBy ="jobAdvertisement")
    @BatchSize(size = 20)
    private List<JobApplication> jobApplications;
}
