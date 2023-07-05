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
@Table(name = "jobapplication")
@SQLDelete(sql = "UPDATE JobApplication SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobApplicationFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJobApplicationFilter", condition = "deleted = :isDeleted")
public class JobApplication {
    @EmbeddedId
    private JobApplicationId id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    //@MapsId
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_advertisement_id", insertable = false, updatable = false)
    //@MapsId
    private JobAdvertisement jobAdvertisement;

    private LocalDate applicationDate = LocalDate.now();

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;
}
