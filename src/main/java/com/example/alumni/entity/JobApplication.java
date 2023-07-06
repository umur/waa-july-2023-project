package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @MapsId
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_advertisement_id", insertable = false, updatable = false)
    @MapsId
    private JobAdvertisement jobAdvertisement;

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

}
