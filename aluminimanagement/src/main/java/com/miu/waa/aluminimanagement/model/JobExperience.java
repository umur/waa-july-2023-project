package com.miu.waa.aluminimanagement.model;
<<<<<<< HEAD

import com.miu.waa.aluminimanagement.model.Company;
import com.miu.waa.aluminimanagement.model.Student;
import jakarta.persistence.*;

import java.util.Date;

=======
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobType;
    private String jobPosition;
    private String jobDescription;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
    private Date startDate;
    private Date endDate;
    private boolean isDeleted = false;
}
