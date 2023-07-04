package waa.miu.AlumniManagementPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipcode;

    @OneToOne
    private Faculty faculty;

    @OneToOne
    private CurrentWorkPlace currentWorkPlace;

    @OneToOne
    private Student student;


}
