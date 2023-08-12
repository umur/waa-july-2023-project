package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JobApplicationId implements Serializable {

    private Long userId;
    private Long jobAdvertisementId;
}
