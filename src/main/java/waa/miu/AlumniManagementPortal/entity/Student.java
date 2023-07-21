package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Student extends User {

    private String studentId, cv, isCurrentlyEmployed;

//    @JsonManagedReference(value = "student-address")
//    @OneToOne(mappedBy = "student")
    @OneToOne
    private Address address;

    @JsonBackReference(value = "student-major")
    @ManyToOne
    private Major major;

    @JsonManagedReference(value = "student-jobAdverts")
    @OneToMany(mappedBy = "student")
    private List<JobAdvert> jobAdverts;

//    @JsonManagedReference
//    @ManyToMany
//    private List<JobAdvert> jobApplicants;

    @JsonBackReference(value = "student-currentWorkPlace")
    @ManyToOne
    private CurrentWorkPlace currentWorkPlace;

//    @JsonManagedReference(value = "student-comment")
    @OneToMany(mappedBy = "student")
    private List<Comment> comments;

    @ManyToMany
    private List<JobsApplied> jobsApplied;

}
