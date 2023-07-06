package com.twohundred.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.twohundred.alumni.entity.Student;

public interface StudentRepo extends ListCrudRepository<Student, Long> {
}
