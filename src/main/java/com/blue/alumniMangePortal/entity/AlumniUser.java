package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class AlumniUser {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    @JsonIgnore
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;


}
