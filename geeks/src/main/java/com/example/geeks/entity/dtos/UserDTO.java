package com.example.geeks.entity.dtos;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.Experience;
import com.example.geeks.entity.Log;
import com.example.geeks.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    @JsonSerialize
    private Long id;

    @JsonSerialize
    private String name;

    @JsonSerialize
    private String image;

    @JsonSerialize
    private String email;
//
//    @JsonSerialize
//    private String state;
//
//    @JsonSerialize
//    private String city;
//
//    @JsonSerialize
//    private String major;

    @JsonSerialize
    private Role role;

    @JsonSerialize
    private boolean active;

//    @JsonSerialize
//    private String cv;
//
    @JsonSerialize
    private boolean deleted;

    // navigation properties

//    @JsonSerialize
//    private List<Log> logs;
//
//    @JsonSerialize
//    private List<Experience> experiences;
//
//    @JsonSerialize
//    private List<Comment> givenComments;
//
//    @JsonSerialize
//    private List<Comment> receivedComments;

}
