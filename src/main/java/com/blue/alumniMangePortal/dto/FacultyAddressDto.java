package com.blue.alumniMangePortal.dto;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Faculty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FacultyAddressDto {
    private Faculty faculty;
    private Address address;
}
