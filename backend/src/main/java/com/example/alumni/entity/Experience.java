package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Experience  extends BaseEntity {

    private String companyName;
    private String city;
    private String State;
    @Lob
    private String companyDescription;
    private String jobTitle;
    private LocalDate startDate;
    private LocalDate exitDate;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;


}

