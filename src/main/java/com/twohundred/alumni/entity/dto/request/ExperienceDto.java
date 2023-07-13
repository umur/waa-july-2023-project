package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class ExperienceDto {
    private Long starDate;
    private Long endDate;
    private String company;
    private String title;
}
