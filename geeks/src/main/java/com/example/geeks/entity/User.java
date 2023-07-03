package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String username;
    private String password;
    private String email;
    private String state;
    private String city;
    private String major;
    private String role;
    private boolean isActive;
    private String cv;
    private boolean isDeleted;

    // navigation properties
    @OneToMany(mappedBy = "user")
    private List<Log> logs;

    @OneToMany(mappedBy = "user")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "commentGiver")
    private List<Comment> givenComments;

    @OneToMany(mappedBy = "commentReceiver")
    private List<Comment> receivedComments;

    @OneToMany(mappedBy = "creator")
    private List<Advertisement> createdAdvertisments;

    @ManyToMany
    private List<Advertisement> applicatedAdvertisments;
}
