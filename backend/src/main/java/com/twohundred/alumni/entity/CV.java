package com.twohundred.alumni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CV {
    @Id
    @EmbeddedId
    private CVId id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId(value = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_ad_id")
    @MapsId(value = "jobAdId")
    private JobAdvertisement jobAd;

    private LocalDate createdDate;
}
