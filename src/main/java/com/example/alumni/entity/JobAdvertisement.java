package com.example.alumni.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE JobAdvertisement SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobAdvertisementFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJobAdvertisementFilter", condition = "deleted = :isDeleted")
public class JobAdvertisement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionTitle;
    private String Description;
    private Double minSalary;
    private Double maxSalary;
    private String requiredSkills;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    private boolean deleted = Boolean.FALSE;
}
