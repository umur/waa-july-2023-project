package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@Table(name="JobApplication")
@SQLDelete(sql = "UPDATE JobApplication SET deleted = true WHERE id=?")
@FilterDef(name = "deletedJobApplicationFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedJJobApplicationFilter", condition = "deleted = :isDeleted")
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


}
