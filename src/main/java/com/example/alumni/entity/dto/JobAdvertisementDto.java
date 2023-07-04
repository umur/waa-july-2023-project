package com.example.alumni.entity.dto;

import com.example.alumni.entity.Tag;
import com.example.alumni.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.List;


@Setter
@Getter
public class JobAdvertisementDto {
    private Long id;
    private String positionTitle;
    private String Description;
    private Double minSalary;
    private Double maxSalary;
    private String requiredSkills;
    private List<Tag> tags;
    private User user;
}
