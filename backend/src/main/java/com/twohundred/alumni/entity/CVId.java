package com.twohundred.alumni.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CVId implements Serializable {
    private Long studentId;
    private int jobAdId;
}
