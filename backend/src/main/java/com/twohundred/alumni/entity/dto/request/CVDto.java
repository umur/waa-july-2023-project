package com.twohundred.alumni.entity.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVDto {
    private CVIdDto id;
    private String text;
    private StudentDto student;
    private JobAdvertisementDto jobAd;
    private LocalDate createdDate;
}
