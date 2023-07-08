package com.twohundred.alumni.entity.dto.request;

import com.twohundred.alumni.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<Tag> tags;
    private Long facultyId;
    private List<String> files;
    private String dateCreated;
}
