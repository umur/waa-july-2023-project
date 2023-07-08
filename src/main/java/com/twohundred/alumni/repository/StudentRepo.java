package com.twohundred.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends ListCrudRepository<Student, Long> {
    List<Student> findAllByFirstNameOrLastNameLike(String firstname, String lastname);

    List<Student> findAllByStateLike(String state);

    List<Student> findAllByCityLike(String city);

    List<Student> findAllByMajorLike(String major);
}
