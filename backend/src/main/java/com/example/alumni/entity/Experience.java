package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@SQLDelete(sql = "UPDATE Experience SET deleted = true WHERE id=?")
@FilterDef(name = "deletedExperienceFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedExperienceFilter", condition = "deleted = :isDeleted")
public class Experience implements Serializable {

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

    private String companyName;
    private String city;
    private String State;
    @Lob
    private String companyDescription;
    private String jobTitle;
    private LocalDate startDate;
    private LocalDate exitDate;

}

