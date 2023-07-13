package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobApplicationId implements Serializable {

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "job_advertisement_id")
//    private JobAdvertisement jobAdvertisement;
    private Long userId;
    private Long jobAdvertisementId;
}
