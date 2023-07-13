//package com.example.alumni.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//
//@Entity
//@Data
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@NoArgsConstructor
//@AllArgsConstructor
//public abstract class BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    @JsonIgnore
//    private boolean deleted = Boolean.FALSE;
//
//    @JsonIgnore
//    @CreationTimestamp
//    private LocalDateTime createDateTime;
//
//    @JsonIgnore
//    @UpdateTimestamp
//    private LocalDateTime updateDateTime;
//
//    @Version
//    private int version;
//
//}
