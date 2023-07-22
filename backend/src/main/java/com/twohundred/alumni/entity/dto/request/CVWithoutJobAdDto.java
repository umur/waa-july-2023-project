package com.twohundred.alumni.entity.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVWithoutJobAdDto {
    private CVIdDto id;
    private StudentWithoutCVDto student;
    private String text;
    private LocalDate createdDate;
}
