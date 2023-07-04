package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;

@Entity
@Data
@SQLDelete(sql = "UPDATE Experience SET deleted = true WHERE id=?")
@FilterDef(name = "deletedExperienceFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedExperienceFilter", condition = "deleted = :isDeleted")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private String city;
    private String State;
    private String companyDescription;
    private String jobTitle;
    private LocalDate startDate;
    private LocalDate exitDate;

    private boolean deleted = Boolean.FALSE;

}

