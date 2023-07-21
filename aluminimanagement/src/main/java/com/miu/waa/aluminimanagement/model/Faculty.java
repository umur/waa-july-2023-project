package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("faculty")
public class Faculty extends Person {
    private String majorSubject;
    private Boolean isActive=false;
}
