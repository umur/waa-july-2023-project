package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "jobapplication")
@SQLDelete(sql = "UPDATE JobApplication SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobApplicationFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJobApplicationFilter", condition = "deleted = :isDeleted")
public class JobApplication implements Serializable {

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

    @EmbeddedId
    private JobApplicationId id;

    @ManyToOne
    //@JoinColumn(name = "user_id", insertable = false, updatable = false)
    @MapsId("userId")
    private User user;

    @ManyToOne
    //@JoinColumn(name = "job_advertisement_id", insertable = false, updatable = false)
    @MapsId("jobAdvertisementId")
    private JobAdvertisement jobAdvertisement;

}
