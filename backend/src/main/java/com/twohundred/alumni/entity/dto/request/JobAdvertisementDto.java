package com.twohundred.alumni.entity.dto.request;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
    private int id;
    private String description;
    private String benefits;
    private String companyName;
    private String state;
    private String city;
    private List<TagDto> tags;
    private Long facultyId;
    private StudentDto createdStudent;
    private List<String> files;
    private Date dateCreated;
}
