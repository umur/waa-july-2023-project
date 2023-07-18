package com.twohundred.alumni.entity.dto.request;

import java.time.LocalDate;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVDto {
    private CVIdDto id;
    private String text;
    private Student student;
    private JobAdvertisement jobAd;
    private LocalDate createdDate;
}
