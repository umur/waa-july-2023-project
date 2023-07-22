package waa.miu.AlumniManagementPortal.dto;

import lombok.Data;
import waa.miu.AlumniManagementPortal.entity.*;

import java.util.List;

@Data
public class StudentDto {
    private Long id;

    private String firstName, lastName, email, password, phone, studentId, cv, isCurrentlyEmployed, isDeleted;
    private Address address;
    private Role role;
    private Major major;
    private List<JobAdvert> jobAdverts;
    private CurrentWorkPlace currentWorkPlace;
}

