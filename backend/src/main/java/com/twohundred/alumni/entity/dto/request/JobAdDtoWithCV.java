package com.twohundred.alumni.entity.dto.request;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobAdDtoWithCV {
    private int id;
    private String description;
    private String benefits;
    private String companyName;
    private String state;
    private String city;
    private List<TagDto> tags;
    private StudentDto createdStudent;
    private List<String> files;
    private Date dateCreated;
    private List<CVDto> cvs;
}
