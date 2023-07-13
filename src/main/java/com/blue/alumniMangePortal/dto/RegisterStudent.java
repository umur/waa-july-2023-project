package com.blue.alumniMangePortal.dto;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.Major;
import com.blue.alumniMangePortal.entity.Role;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudent {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isDeleted;
    private boolean currentlyEmployed;
    private Address address;
    private Major major;
    private Role role;
}
